
class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                cost[i][j] = Integer.MAX_VALUE;

                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;

                    int changes = 0;

                    for (int r = 0; r < d; r++) {
                        int left = i + r;
                        int right = i + r + ((len - 1) / d) * d;

                        while (left < right) {
                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    cost[i][j] = Math.min(cost[i][j], changes);
                }
            }
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }

        dp[0][0] = 0;

        for (int groups = 1; groups <= k; groups++) {
            for (int i = 2 * groups; i <= n; i++) {
                for (int t = 2 * (groups - 1); t <= i - 2; t++) {
                    dp[i][groups] = Math.min(
                        dp[i][groups],
                        dp[t][groups - 1] + cost[t][i - 1]
                    );
                }
            }
        }

        return dp[n][k];
    }
}
