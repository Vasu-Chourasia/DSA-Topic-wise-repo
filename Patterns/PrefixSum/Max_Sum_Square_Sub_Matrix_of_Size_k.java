class Solution {
    public int maximumSum(int[][] mat, int k) {
        int n = mat.length;
        int[][] prefix = new int[n + 1][n + 1];
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                prefix[row][col] = mat[row - 1][col - 1]
                        + prefix[row - 1][col]
                        + prefix[row][col - 1]
                        - prefix[row - 1][col - 1];
            }
        }
        int maxSum = Integer.MIN_VALUE;
        for (int row = k; row <= n; row++) {
            for (int col = k; col <= n; col++) {
                int currentSum = prefix[row][col]
                        - prefix[row - k][col]
                        - prefix[row][col - k]
                        + prefix[row - k][col - k];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }
}