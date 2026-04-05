class Solution {
    public int totalWays(int[] arr, int target) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (target > sum || (target + sum) % 2 != 0) {
            return 0;
        }
        int subsetSum = (target + sum) / 2;
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;
        for (int num : arr) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[subsetSum];
    }
}