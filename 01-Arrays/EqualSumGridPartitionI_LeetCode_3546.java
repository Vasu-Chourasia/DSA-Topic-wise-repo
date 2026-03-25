class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long total = 0;

        // total sum
        for(int[] row : grid){
            for(int val : row){
                total += val;
            }
        }

        // if odd → impossible
        if(total % 2 != 0) return false;

        // check horizontal cut
        long curr = 0;
        for(int i = 0; i < m - 1; i++){   // must leave non-empty bottom
            for(int j = 0; j < n; j++){
                curr += grid[i][j];
            }
            if(curr * 2 == total) return true;
        }

        // check vertical cut
        curr = 0;
        for(int j = 0; j < n - 1; j++){   // must leave non-empty right
            for(int i = 0; i < m; i++){
                curr += grid[i][j];
            }
            if(curr * 2 == total) return true;
        }

        return false;
    }
}