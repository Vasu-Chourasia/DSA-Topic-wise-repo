class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        // Reduce unnecessary rotations
        k = k % n;

        // Traverse each row
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int newIndex;

                // Even row → left shift
                if (i % 2 == 0) {
                    newIndex = (j + k) % n;
                } 
                // Odd row → right shift
                else {
                    newIndex = (j - k % n + n) % n;
                }

                // Compare with original
                if (mat[i][j] != mat[i][newIndex]) {
                    return false;
                }
            }
        }

        return true;
    }
}