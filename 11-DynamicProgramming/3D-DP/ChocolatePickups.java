class Solution {

    // Directions robots can move in columns
    int[] dir = {-1, 0, 1};

    public int maxChocolate(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;

        // 3D DP array initialized with -1 (unvisited)
        int[][][] dp = new int[n][m][m];
        for (int i = 0; i < n; i++) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    dp[i][j1][j2] = -1;
                }
            }
        }

        // Start from row 0, robot1 at 0, robot2 at m-1
        return solve(0, 0, m - 1, grid, dp);
    }

    private int solve(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        int n = grid.length;
        int m = grid[0].length;

        // Out of bounds → invalid path
        if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m) {
            return (int) -1e9; // very small value
        }

        // Base case: last row
        if (i == n - 1) {
            if (j1 == j2)
                return grid[i][j1]; // same cell counted once
            else
                return grid[i][j1] + grid[i][j2];
        }

        // Already computed
        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        int max = Integer.MIN_VALUE;

        // Try all 9 combinations
        for (int d1 : dir) {
            for (int d2 : dir) {

                int value;

                // If both robots at same cell
                if (j1 == j2)
                    value = grid[i][j1];
                else
                    value = grid[i][j1] + grid[i][j2];

                // Recursive call
                value += solve(i + 1, j1 + d1, j2 + d2, grid, dp);

                max = Math.max(max, value);
            }
        }

        return dp[i][j1][j2] = max;
    }
}