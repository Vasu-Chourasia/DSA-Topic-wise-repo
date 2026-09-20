class Solution {
    public int largestSubsquare(char mat[][]) {
        int n=mat.length;
        int[][] left=new int[n][n];
        int[][] up =new int[n][n];
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (mat[i][j] == 'X') {
                    left[i][j] = 1;
                    up[i][j] = 1;
                    if(j>0)
                        left[i][j] += left[i][j - 1];
                    if(i>0)
                        up[i][j]+=up[i-1][j];
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                int maxSize=Math.min(left[i][j], up[i][j]);
                for (int size=maxSize; size > ans; size--) {

                    int top=i-size+1;
                    int leftCol=j-size+1;

                    if (top<0||leftCol<0)
                        continue;
                    if (left[top][j]<size)
                        continue;
                    if (up[i][leftCol]<size)
                        continue;
                    ans=size;
                }
            }
        }
        return ans;
    }
}