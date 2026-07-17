class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums)
            max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums)
            freq[x]++;

        long[] divisible = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                divisible[i] += freq[j];
            }
        }

        long[] exact = new long[max + 1];
        for (int i = max; i >= 1; i--) {
            long cnt = divisible[i];
            long pairs = cnt * (cnt - 1) / 2;
            for (int j = i * 2; j <= max; j += i) {
                pairs -= exact[j];
            }
            exact[i] = pairs;
        }

        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + exact[i];
        }

        int[] ans = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            long target = queries[k] + 1;
            int lo = 1, hi = max;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (prefix[mid] >= target)
                    hi = mid;
                else
                    lo = mid + 1;
            }
            ans[k] = lo;
        }

        return ans;
    }
}