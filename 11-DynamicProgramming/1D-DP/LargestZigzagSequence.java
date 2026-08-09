class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;
        int[] dp = new int[n];

        for (int j = 0; j < n; j++) {
            dp[j] = mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            int maxCol = -1;

            for (int j = 0; j < n; j++) {
                if (dp[j] > max1) {
                    max2 = max1;
                    max1 = dp[j];
                    maxCol = j;
                }
                else if (dp[j] > max2) {
                    max2 = dp[j];
                }
            }

            int[] curr = new int[n];

            for (int j = 0; j < n; j++) {
                if (j == maxCol) {
                    curr[j] = mat[i][j] + max2;
                }
                else {
                    curr[j] = mat[i][j] + max1;
                }
            }

            dp = curr;
        }

        int ans = Integer.MIN_VALUE;

        for (int value : dp) {
            ans = Math.max(ans, value);
        }

        return ans;
    }
}