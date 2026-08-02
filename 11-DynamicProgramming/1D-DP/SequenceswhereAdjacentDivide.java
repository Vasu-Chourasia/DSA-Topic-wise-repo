class Solution {
    public int count(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int value = 1; value <= m; value++) {
            dp[1][value] = 1;
        }

        for (int length = 2; length <= n; length++) {
            for (int curr = 1; curr <= m; curr++) {
                for (int prev = 1; prev <= m; prev++) {
                    if (curr % prev == 0 || prev % curr == 0)
                        dp[length][curr] += dp[length - 1][prev];
                }
            }
        }

        int answer = 0;

        for (int value = 1; value <= m; value++) {
            answer += dp[n][value];
        }

        return answer;
    }
}