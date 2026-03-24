class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int MOD = 12345;

        int size = n * m;

        // Step 1: Flatten the grid into 1D array
        int[] arr = new int[size];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[idx++] = grid[i][j] % MOD; 
            }
        }

        // Step 2: Build prefix product array
        int[] prefix = new int[size];
        prefix[0] = 1; // no element before first
        for (int i = 1; i < size; i++) {
            prefix[i] = (prefix[i - 1] * arr[i - 1]) % MOD;
        }

        // Step 3: Build suffix product array
        int[] suffix = new int[size];
        suffix[size - 1] = 1; // no element after last
        for (int i = size - 2; i >= 0; i--) {
            suffix[i] = (suffix[i + 1] * arr[i + 1]) % MOD;
        }

        // Step 4: Build result matrix
        int[][] result = new int[n][m];
        idx = 0;

        for (int i = 0; i < size; i++) {
            int val = (prefix[i] * suffix[i]) % MOD;
            result[idx / m][idx % m] = val;
            idx++;
        }

        return result;
    }
}