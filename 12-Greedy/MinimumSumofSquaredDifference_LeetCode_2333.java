class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int n = nums1.length;
        int[] diff = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        long total = 0;
        for (int d : diff) total += d;

        if (total <= k) return 0;

        int left = 0, right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) needed += d - mid;
            }

            if (needed <= k) right = mid;
            else left = mid + 1;
        }

        int limit = left;
        long answer = 0;

        for (int d : diff) {
            if (d > limit) d = limit;
            answer += (long) d * d;
        }

        long used = 0;
        for (int d : diff) {
            if (d > limit) used += d - limit;
        }

        long remaining = k - used;

        for (int d : diff) {
            if (remaining == 0) break;
            if (d >= limit && d > 0) {
                answer -= (long) limit * limit;
                answer += (long) (limit - 1) * (limit - 1);
                remaining--;
            }
        }

        return answer;
    }
}