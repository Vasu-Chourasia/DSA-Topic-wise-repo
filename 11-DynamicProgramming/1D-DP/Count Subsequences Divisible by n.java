class Solution {
    static final int MOD = 1_000_000_007;

    public int countSubsequences(String s, int n) {
        long[] dp = new long[n];
        for (char ch : s.toCharArray()) {
            int digit = ch - '0';
            long[] next = dp.clone();
            next[digit % n] = (next[digit % n] + 1) % MOD;
            for (int rem = 0; rem < n; rem++) {
                if (dp[rem] == 0) continue;

                int newRem = (rem * 10 + digit) % n;
                next[newRem] = (next[newRem] + dp[rem]) % MOD;
            }
            dp = next;
        }
        return (int) dp[0];
    }
}