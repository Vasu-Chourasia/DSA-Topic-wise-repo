class Solution {
    public long pairAndSum(int[] arr) {
        long ans = 0;

        for (int bit = 0; bit < 31; bit++) {
            long cnt = 0;

            for (int num : arr) {
                if ((num & (1 << bit)) != 0) {
                    cnt++;
                }
            }

            ans += (cnt * (cnt - 1) / 2) * (1L << bit);
        }

        return ans;
    }
}