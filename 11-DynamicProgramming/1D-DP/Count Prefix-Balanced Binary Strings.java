class Solution {
    static final int MOD = 1000000007;
    long power(long a, long b) {
        long res = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
    public int prefixStrings(int n) {
        int m = 2 * n;
        long[] fact = new long[m + 1];
        fact[0] = 1;
        for (int i = 1; i <= m; i++)
            fact[i] = (fact[i - 1] * i) % MOD;
        long ans = fact[m];
        ans = (ans * power(fact[n], MOD - 2)) % MOD;
        ans = (ans * power(fact[n], MOD - 2)) % MOD;
        ans = (ans * power(n + 1, MOD - 2)) % MOD;

        return (int) ans;
    }
}