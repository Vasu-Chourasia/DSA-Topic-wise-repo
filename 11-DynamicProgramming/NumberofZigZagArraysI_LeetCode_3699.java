class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int mod = 1000000007;
        int m = r - l + 1;

        long[][] dpUp = new long[n + 1][m];
        long[][] dpDown = new long[n + 1][m];

        for (int i = 0; i < m; i++)
        {
            dpUp[1][i] = 1;
            dpDown[1][i] = 1;
        }

        for (int i = 2; i <= n; i++)
        {
            long[] prefixUp = new long[m];
            long[] prefixDown = new long[m];

            prefixUp[0] = dpUp[i - 1][0];
            prefixDown[0] = dpDown[i - 1][0];

            for (int j = 1; j < m; j++)
            {
                prefixUp[j] = (prefixUp[j - 1] + dpUp[i - 1][j]) % mod;
                prefixDown[j] = (prefixDown[j - 1] + dpDown[i - 1][j]) % mod;
            }

            for (int j = 0; j < m; j++)
            {
                long up = j > 0 ? prefixDown[j - 1] : 0;
                long down = j < m - 1 ? (prefixUp[m - 1] - prefixUp[j] + mod) % mod : 0;

                dpUp[i][j] = up;
                dpDown[i][j] = down;
            }
        }

        long ans = 0;

        for (int i = 0; i < m; i++)
        {
            ans = (ans + dpUp[n][i] + dpDown[n][i]) % mod;
        }

        return (int) ans;
    }
}