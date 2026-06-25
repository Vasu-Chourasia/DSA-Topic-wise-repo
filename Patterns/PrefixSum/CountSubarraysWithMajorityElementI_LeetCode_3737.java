class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        int ans = 0;

        for (int j = 1; j <= n; j++) {
            for (int i = 0; i < j; i++) {
                if (prefix[j] > prefix[i]) {
                    ans++;
                }
            }
        }

        return ans;
    }
}