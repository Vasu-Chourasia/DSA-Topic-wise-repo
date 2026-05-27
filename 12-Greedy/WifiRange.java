class Solution{
    public boolean wifiRange(String s,int x){
        int n=s.length();
        int[] cover=new int[n];

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                int l=Math.max(0,i-x);
                int r=Math.min(n-1,i+x);
                cover[l]++;
                if(r+1<n)cover[r+1]--;
            }
        }

        int curr=0;

        for(int i=0;i<n;i++){
            curr+=cover[i];
            if(curr==0)return false;
        }

        return true;
    }
}