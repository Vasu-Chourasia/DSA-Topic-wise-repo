class Solution {
    int[][][] dp;
    int[] arr;
    int n;
    public int minCount(int[] arr) {
        this.arr = arr;
        this.n = arr.length;
        dp = new int[n + 1][n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, n, n);
    }
    private int solve(int idx, int incLast, int decLast) {
        if (idx == n) return 0;
        if (dp[idx][incLast][decLast] != -1)
            return dp[idx][incLast][decLast];
        int ans = 1 + solve(idx + 1, incLast, decLast);
        if (incLast == n || arr[idx] > arr[incLast]) {
            ans = Math.min(ans, solve(idx + 1, idx, decLast));
        }
        if (decLast == n || arr[idx] < arr[decLast]) {
            ans = Math.min(ans, solve(idx + 1, incLast, idx));
        }

        return dp[idx][incLast][decLast] = ans;
    }
}