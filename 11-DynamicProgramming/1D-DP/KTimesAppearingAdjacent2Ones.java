class Solution {
    static final int MOD = 1000000007;
    public int countStrings(int n, int k) {
        long[][][] dp = new long[n + 1][k + 2][2];
        dp[1][0][0] = 1;
        dp[1][0][1] = 1;
        for (int pos = 1; pos < n; pos++) {
            for (int cnt = 0; cnt <= k; cnt++) {
                if (dp[pos][cnt][0] > 0) {
                    dp[pos + 1][cnt][0] =
                            (dp[pos + 1][cnt][0] + dp[pos][cnt][0]) % MOD;
                    dp[pos + 1][cnt][1] =
                            (dp[pos + 1][cnt][1] + dp[pos][cnt][0]) % MOD;
                }
                if (dp[pos][cnt][1] > 0) {
                    dp[pos + 1][cnt][0] =
                            (dp[pos + 1][cnt][0] + dp[pos][cnt][1]) % MOD;
                    if (cnt + 1 <= k) {
                        dp[pos + 1][cnt + 1][1] =
                                (dp[pos + 1][cnt + 1][1] + dp[pos][cnt][1]) % MOD;
                    }
                }
            }
        }
        return (int) ((dp[n][k][0] + dp[n][k][1]) % MOD);
    }
}