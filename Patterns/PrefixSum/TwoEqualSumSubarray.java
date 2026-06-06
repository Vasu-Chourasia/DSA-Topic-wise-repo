class Solution {
    public boolean canSplit(int arr[]) {
        int n = arr.length;

        // Step 1: Calculate total sum
        long total = 0;
        for (int num : arr) {
            total += num;
        }

        // Step 2: If total is odd, cannot split
        if (total % 2 != 0) {
            return false;
        }

        long target = total / 2;

        // Step 3: Traverse and check prefix sum
        long prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            // If prefix sum equals target, we found valid split
            if (prefixSum == target) {
                return true;
            }
        }

        return false;
    }
}