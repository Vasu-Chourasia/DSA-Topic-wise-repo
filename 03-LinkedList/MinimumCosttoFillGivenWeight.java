class Solution {
    public int minimumCost(int[] cost, int w) {
        int n = cost.length;
        int[] dp = new int[w + 1];

        for (int i = 0; i <= w; i++)
        {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for (int i = 1; i <= w; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int weight = j + 1;

                if (cost[j] == -1)
                {
                    continue;
                }

                if (weight <= i && dp[i - weight] != Integer.MAX_VALUE)
                {
                    dp[i] = Math.min(dp[i], dp[i - weight] + cost[j]);
                }
            }
        }

        if (dp[w] == Integer.MAX_VALUE)
        {
            return -1;
        }

        return dp[w];
    }
}