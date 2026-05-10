class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) dp[i] = Integer.MIN_VALUE;
        dp[0] = 0;
        
        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MIN_VALUE) continue;
            
            for (int j = i + 1; j < n; j++) {
                long diff = (long) nums[j] - nums[i];
                if (diff >= -target && diff <= target) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        
        return dp[n - 1] == Integer.MIN_VALUE ? -1 : dp[n - 1];
    }
}