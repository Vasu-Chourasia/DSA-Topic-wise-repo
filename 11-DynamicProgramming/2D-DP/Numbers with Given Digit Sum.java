class Solution {
    int[][] dp;

    public int countWays(int n, int sum) {
        if (sum > 9 * n || sum < 1)
            return -1;

        dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++)
            java.util.Arrays.fill(dp[i], -1);

        int ans = 0;

        for (int d = 1; d <= 9; d++)
        {
            if (sum >= d)
                ans += solve(1, n, sum - d);
        }

        return ans == 0 ? -1 : ans;
    }

    private int solve(int pos, int n, int rem) {
        if (pos == n)
            return rem == 0 ? 1 : 0;

        if (dp[pos][rem] != -1)
            return dp[pos][rem];

        int ways = 0;

        for (int d = 0; d <= 9; d++)
        {
            if (rem >= d)
                ways += solve(pos + 1, n, rem - d);
        }

        return dp[pos][rem] = ways;
    }
}