class Solution {
    static final int MOD = 1_000_000_007;
    int minOperations(int[] b) {
        int n = b.length;
        boolean[] vis = new boolean[n];
        long ans = 1;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int len = 0;
                int cur = i;
                while (!vis[cur]) {
                    vis[cur] = true;
                    cur = b[cur] - 1;
                    len++;
                }
                ans = lcm(ans, len);
            }
        }
        return (int) (ans % MOD);
    }
    long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}