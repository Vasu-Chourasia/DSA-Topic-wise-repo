class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long p = 1000;

        while (p <= n) {
            ans += (n - p + 1);

            // Prevent overflow when multiplying by 1000
            if (p > Long.MAX_VALUE / 1000) {
                break;
            }
            p *= 1000;
        }

        return ans;
    }
}