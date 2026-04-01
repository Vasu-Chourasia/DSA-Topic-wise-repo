class Solution {
    public int countStrings(int n) {
        if (n == 1) return 2;
        int dp0 = 1;
        int dp1 = 1;

        for (int i = 2; i <= n; i++) {
            int new_dp0 = dp0 + dp1; 
            int new_dp1 = dp0;  
            dp0 = new_dp0;
            dp1 = new_dp1;
        }

        return dp0 + dp1;
    }
}