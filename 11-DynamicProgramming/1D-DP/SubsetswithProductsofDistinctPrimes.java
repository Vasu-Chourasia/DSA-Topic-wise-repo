class Solution {
    static final int MOD = 1_000_000_007;

    public int countSubsets(int[] arr) {
        int[] freq = new int[31];
        for (int x : arr) {
            freq[x]++;
        }
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int[] masks = new int[31];
        for (int i = 2; i <= 30; i++) {
            masks[i] = getMask(i, prime);
        }
        long[] dp = new long[1 << 10];
        dp[0] = 1;
        for (int num = 2; num <= 30; num++) {
            if (freq[num] == 0 || masks[num] == -1) {
                continue;
            }
            int mask = masks[num];
            for (int state = (1 << 10) - 1; state >= 0; state--) {
                if ((state & mask) != 0) {
                    continue;
                }
                dp[state | mask] = (dp[state | mask] + dp[state] * freq[num]) % MOD;
            }
        }
        long mul = 1;
        while (freq[1]-- > 0) {
            mul = (mul * 2) % MOD;
        }
        long ans = 0;
        for (int i = 1; i < (1 << 10); i++) {
            ans = (ans + dp[i]) % MOD;
        }
        ans = (ans * mul) % MOD;
        return (int) ans;
    }

    private int getMask(int num, int[] prime) {
        int mask = 0;
        for (int i = 0; i < 10; i++) {
            int p = prime[i];
            if (num % (p * p) == 0) {
                return -1;
            }
            if (num % p == 0) {
                mask |= 1 << i;
            }
        }
        return mask;
    }
}