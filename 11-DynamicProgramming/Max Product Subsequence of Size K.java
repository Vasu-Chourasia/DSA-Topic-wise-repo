class Solution {
    public int maxProduct(int[] arr,int k) {
        int n=arr.length;
        long[][] max=new long[k+1][n+1];
        long[][] min=new long[k+1][n+1];

        for(int j=0;j<=k;j++) {
            Arrays.fill(max[j],Long.MIN_VALUE);
            Arrays.fill(min[j],Long.MAX_VALUE);
        }

        max[0][0]=min[0][0]=1;

        for(int i=1;i<=n;i++) {
            int x=arr[i-1];

            for(int j=0;j<=Math.min(i,k);j++) {
                max[j][i]=max[j][i-1];
                min[j][i]=min[j][i-1];

                if(j>0) {
                    if(max[j-1][i-1]!=Long.MIN_VALUE) {
                        long p=max[j-1][i-1]*x;
                        max[j][i]=Math.max(max[j][i],p);
                        min[j][i]=Math.min(min[j][i],p);
                    }

                    if(min[j-1][i-1]!=Long.MAX_VALUE) {
                        long p=min[j-1][i-1]*x;
                        max[j][i]=Math.max(max[j][i],p);
                        min[j][i]=Math.min(min[j][i],p);
                    }
                }
            }
        }

        return (int)max[k][n];
    }
}