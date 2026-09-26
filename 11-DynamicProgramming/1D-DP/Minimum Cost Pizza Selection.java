class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        int INF = Integer.MAX_VALUE / 2;
        int[] dp = new int[x + 1];
        for (int i = 1; i <= x; i++)
            dp[i] = INF;
        for (int area = 0; area <= x; area++) {
            int next = Math.min(x, area + s);
            dp[next] = Math.min(dp[next], dp[area] + cs);
            next = Math.min(x, area + m);
            dp[next] = Math.min(dp[next], dp[area] + cm);

            next = Math.min(x, area + l);
            dp[next] = Math.min(dp[next], dp[area] + cl);
        }

        return dp[x];
    }
}