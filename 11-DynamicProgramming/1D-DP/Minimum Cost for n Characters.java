class Solution {
    public int minCost(int n, int i, int d, int c) {
        int[] dp = new int[n + 2];
        dp[0] = 0;
        for (int len = 1; len <= n; len++) {
            dp[len] = dp[len - 1] + i;
            if (len % 2 == 0) {
                dp[len] = Math.min(dp[len], dp[len / 2] + c);
            } else {
                dp[len] = Math.min(dp[len],
                        dp[(len + 1) / 2] + c + d);
                dp[len] = Math.min(dp[len],
                        dp[(len - 1) / 2] + c + i);
            }
        }
        return dp[n];
    }
}