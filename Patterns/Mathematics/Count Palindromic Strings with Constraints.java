class Solution {
    public int palindromicStrings(int n, int k) {
        final int MOD = 1000000007;
        long ans = 0;
        long permOdd = k;
        if (n >= 1) {
            ans = (ans + permOdd) % MOD;
        }
        for (int m = 1; 2 * m + 1 <= n; m++) {
            permOdd = (permOdd * (k - m)) % MOD;
            ans = (ans + permOdd) % MOD;
        }
        long permEven = 1;
        for (int m = 1; 2 * m <= n; m++) {
            permEven = (permEven * (k - m + 1)) % MOD;
            ans = (ans + permEven) % MOD;
        }
        return (int) ans;
    }
}