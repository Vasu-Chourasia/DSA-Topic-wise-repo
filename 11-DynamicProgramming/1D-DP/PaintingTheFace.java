class Solution {
    public int countWays(int n, int k) {
        // Base cases
        if (n == 1) return k;
        if (n == 2) return k * k;

        int prev2 = k;        // dp[1]
        int prev1 = k * k;    // dp[2]

        for (int i = 3; i <= n; i++) {
            int curr = (prev1 + prev2) * (k - 1);

            // shift values
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}