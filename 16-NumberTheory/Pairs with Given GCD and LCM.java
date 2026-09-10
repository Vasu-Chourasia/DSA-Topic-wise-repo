class Solution {
    public int pairCount(int x, int y) {
        if (y % x != 0) {
            return 0;
        }

        int k = y / x;
        int ans = 0;

        for (int d = 1; d * d <= k; d++) {
            if (k % d == 0) {
                int e = k / d;

                if (gcd(d, e) == 1) {
                    if (d == e)
                        ans += 1;
                    else
                        ans += 2;
                }
            }
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}