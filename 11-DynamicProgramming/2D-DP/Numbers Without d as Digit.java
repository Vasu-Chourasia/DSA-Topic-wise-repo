class Solution {
    long[][][] dp;
    char[] num;
    int forbidden;
    public int countWithout(int n, int d) {
        if (n == 0)
            return 0;
        forbidden = d;
        num = String.valueOf(n).toCharArray();
        dp = new long[num.length][2][2];
        for (int i = 0; i < num.length; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 2; k++)
                    dp[i][j][k] = -1;
        return (int)(solve(0, 1, 0) - 1);
    }
    private long solve(int pos, int tight, int started) {
        if (pos == num.length)
            return 1;
        if (dp[pos][tight][started] != -1)
            return dp[pos][tight][started];
        int limit;
        if (tight == 1)
            limit = num[pos] - '0';
        else
            limit = 9;
        long res = 0;
        for (int digit = 0; digit <= limit; digit++) {
            int newTight;
            if (tight == 1 && digit == limit)
                newTight = 1;
            else
                newTight = 0;
            if (started == 0 && digit == 0)
                res += solve(pos + 1, newTight, 0);
            else if (digit != forbidden)
                res += solve(pos + 1, newTight, 1);
        }
        dp[pos][tight][started] = res;
        return res;
    }
}