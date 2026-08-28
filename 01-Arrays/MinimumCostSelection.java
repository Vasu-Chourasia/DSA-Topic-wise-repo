class Solution {
     public int minCost(int[][] mat) {
         int n = mat.length;

         int a = mat[0][0];
         int b = mat[0][1];
         int c = mat[0][2];

         for (int i = 1; i < n; i++) {
             int na = mat[i][0] + Math.min(b, c);
             int nb = mat[i][1] + Math.min(a, c);
             int nc = mat[i][2] + Math.min(a, b);

             a = na;
             b = nb;
             c = nc;
         }

         return Math.min(a, Math.min(b, c));
     }
 }