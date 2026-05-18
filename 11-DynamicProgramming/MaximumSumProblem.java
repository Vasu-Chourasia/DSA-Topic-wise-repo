class Solution {
    public int maxSum(int n) {
        int[] dp=new int[n+1];
        return solve(n,dp);
    }
    int solve(int n,int[] dp){
        if(n==0) return 0;
        if(dp[n]!=0) return dp[n];
        int val=solve(n/2,dp)+solve(n/3,dp)+solve(n/4,dp);
        dp[n]=Math.max(n,val);
        return dp[n];
    }
}