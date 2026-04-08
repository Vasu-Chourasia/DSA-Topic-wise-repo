class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1_000_000_007;

        // Process each query
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            // Start from l and jump by k
            for (int idx = l; idx <= r; idx += k) {
                long val = (1L * nums[idx] * v) % MOD; // avoid overflow
                nums[idx] = (int) val;
            }
        }

        // Compute XOR of final array
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}