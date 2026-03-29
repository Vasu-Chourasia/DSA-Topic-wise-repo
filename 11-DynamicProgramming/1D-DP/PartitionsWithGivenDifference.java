class Solution {
    public int countPartitions(int[] arr, int diff) {
        int n = arr.length;

        // Step 1: Calculate total sum
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Step 2: Check validity
        if ((totalSum + diff) % 2 != 0) return 0;

        int target = (totalSum + diff) / 2;

        // Step 3: DP array
        int[] dp = new int[target + 1];

        // Base case: 1 way to make sum = 0
        dp[0] = 1;

        // Step 4: Fill DP
        for (int num : arr) {
            // Traverse backwards (important!)
            for (int j = target; j >= 0; j--) {
                if (j - num >= 0) {
                    dp[j] += dp[j - num];
                }
            }
        }

        return dp[target];
    }
}