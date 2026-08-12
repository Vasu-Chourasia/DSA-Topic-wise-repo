class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;
        int MOD = 1000000007;

        long[][] ways = new long[n][n];
        int[][] best = new int[n][n];

        for (int i = 0; i < n; i++)
            Arrays.fill(best[i], Integer.MIN_VALUE);

        ways[0][0] = 1;
        best[0][0] = grid[0][0];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (ways[i][j] == 0)
                    continue;

                if ((grid[i][j] == 1 || grid[i][j] == 3) && j + 1 < n)
                {
                    ways[i][j + 1] = (ways[i][j + 1] + ways[i][j]) % MOD;
                    best[i][j + 1] = Math.max(best[i][j + 1], best[i][j] + grid[i][j + 1]);
                }

                if ((grid[i][j] == 2 || grid[i][j] == 3) && i + 1 < n)
                {
                    ways[i + 1][j] = (ways[i + 1][j] + ways[i][j]) % MOD;
                    best[i + 1][j] = Math.max(best[i + 1][j], best[i][j] + grid[i + 1][j]);
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        if (ways[n - 1][n - 1] == 0)
        {
            ans.add(0);
            ans.add(0); 
            return ans;
        }

        ans.add((int)(ways[n - 1][n - 1] % MOD));
        ans.add(best[n - 1][n - 1]);

        return ans;
    }
}