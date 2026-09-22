class Solution {
    int n,k;
    int[][] cnt;
    int[] prod;

    void build(int node,int l,int r,int[] nums){
        if(l==r){
            prod[node]=nums[l]%k;
            cnt[node][prod[node]]=1;
            return;
        }

        int mid=(l+r)/2;
        build(node*2,l,mid,nums);
        build(node*2+1,mid+1,r,nums);
        merge(node);
    }

    void merge(int node){
        int left=node*2,right=node*2+1;

        prod[node]=(prod[left]*prod[right])%k;

        for(int r=0;r<k;r++){
            cnt[node][r]=cnt[left][r];
            for(int x=0;x<k;x++){
                if((x*prod[left])%k==r)
                    cnt[node][r]+=cnt[right][x];
            }
        }
    }

    void update(int node,int l,int r,int idx,int val){
        if(l==r){
            prod[node]=val%k;
            for(int i=0;i<k;i++)
                cnt[node][i]=0;
            cnt[node][prod[node]]=1;
            return;
        }

        int mid=(l+r)/2;

        if(idx<=mid)
            update(node*2,l,mid,idx,val);
        else
            update(node*2+1,mid+1,r,idx,val);

        merge(node);
    }

    int[] query(int node,int l,int r,int ql){
        if(l>=ql)
            return createNode(node);

        int mid=(l+r)/2;

        if(ql<=mid)
            return combine(query(node*2,l,mid,ql),
                           query(node*2+1,mid+1,r,ql));

        return query(node*2+1,mid+1,r,ql);
    }

    int[] createNode(int node){
        int[] res=new int[k+1];
        res[0]=prod[node];

        for(int i=0;i<k;i++)
            res[i+1]=cnt[node][i];

        return res;
    }

    int[] combine(int[] a,int[] b){
        int[] res=new int[k+1];

        res[0]=(a[0]*b[0])%k;

        for(int r=0;r<k;r++){
            res[r+1]=a[r+1];

            for(int x=0;x<k;x++){
                if((x*a[0])%k==r)
                    res[r+1]+=b[x+1];
            }
        }

        return res;
    }

    public int[] resultArray(int[] nums,int k,int[][] queries){
        this.n=nums.length;
        this.k=k;

        cnt=new int[4*n][k];
        prod=new int[4*n];

        build(1,0,n-1,nums);

        int[] ans=new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int index=queries[i][0];
            int value=queries[i][1];
            int start=queries[i][2];
            int x=queries[i][3];

            update(1,0,n-1,index,value);

            int[] res=query(1,0,n-1,start);
            ans[i]=res[x+1];
        }

        return ans;
    }
}