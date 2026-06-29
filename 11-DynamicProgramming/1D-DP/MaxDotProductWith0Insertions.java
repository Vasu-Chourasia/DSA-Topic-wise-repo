class Solution {
    public int maxDotProduct(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        long[][] dp = new long[n + 1][m + 1];
        long NEG = Long.MIN_VALUE / 4;

        for (int j = 1; j <= m; j++) {
            dp[0][j] = NEG;
        }

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (dp[i - 1][j - 1] != NEG) {
                    dp[i][j] = Math.max(
                        dp[i][j],
                        dp[i - 1][j - 1] + 1L * a[i - 1] * b[j - 1]
                    );
                }
            }
        }

        return (int) dp[n][m];
    }
}