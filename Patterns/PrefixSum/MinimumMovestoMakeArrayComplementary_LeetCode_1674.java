class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
    
        int[] diff = new int[2 * limit + 2];
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            int min = Math.min(a, b);
            int max = Math.max(a, b);
            int sum = a + b;

            int low = min + 1;
            int high = max + limit;
            diff[2] += 2;
            diff[2 * limit + 1] -= 2;
            diff[low] -= 1;
            diff[high + 1] += 1;
            diff[sum] -= 1;
            diff[sum + 1] += 1;
        }

        int res = Integer.MAX_VALUE;
        int curr = 0;
        for (int s = 2; s <= 2 * limit; s++) {
            curr += diff[s];
            res = Math.min(res, curr);
        }

        return res;
    }
}