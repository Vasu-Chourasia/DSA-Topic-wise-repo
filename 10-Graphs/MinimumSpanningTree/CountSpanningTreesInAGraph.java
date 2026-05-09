class Solution {

    // Function to compute determinant using Gaussian elimination
    private long determinant(double[][] mat, int n) {
        double det = 1;

        for (int i = 0; i < n; i++) {

            int pivot = i;

            // Find pivot row
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(mat[j][i]) > Math.abs(mat[pivot][i])) {
                    pivot = j;
                }
            }

            // If pivot is zero → determinant = 0
            if (Math.abs(mat[pivot][i]) < 1e-9) {
                return 0;
            }

            // Swap rows
            if (i != pivot) {
                double[] temp = mat[i];
                mat[i] = mat[pivot];
                mat[pivot] = temp;
                det *= -1;
            }

            det *= mat[i][i];

            // Eliminate below
            for (int j = i + 1; j < n; j++) {
                double factor = mat[j][i] / mat[i][i];
                for (int k = i; k < n; k++) {
                    mat[j][k] -= factor * mat[i][k];
                }
            }
        }

        return (long)(det + 0.5); // rounding
    }

    public int countSpanTree(int n, int[][] edges) {

        if (n == 1) return 1;

        // Step 1: Laplacian matrix
        double[][] lap = new double[n][n];

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            lap[u][u]++;
            lap[v][v]++;
            lap[u][v]--;
            lap[v][u]--;
        }

        // Step 2: Remove last row & column
        double[][] mat = new double[n - 1][n - 1];

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                mat[i][j] = lap[i][j];
            }
        }

        // Step 3: determinant
        return (int) determinant(mat, n - 1);
    }
}