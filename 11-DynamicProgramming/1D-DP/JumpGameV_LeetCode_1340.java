class Solution {
    int[] dp;
    
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        dp = new int[n];
        int res = 1;
        
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(arr, d, i));
        }
        
        return res;
    }
    
    private int dfs(int[] arr, int d, int i) {
        if (dp[i] != 0) return dp[i];
        
        int n = arr.length;
        int max = 1;
        
        for (int x = 1; x <= d; x++) {
            int j = i + x;
            if (j >= n || arr[j] >= arr[i]) break;
            max = Math.max(max, 1 + dfs(arr, d, j));
        }
        
        for (int x = 1; x <= d; x++) {
            int j = i - x;
            if (j < 0 || arr[j] >= arr[i]) break;
            max = Math.max(max, 1 + dfs(arr, d, j));
        }
        
        return dp[i] = max;
    }
}