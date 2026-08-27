import java.util.Arrays;

class Solution {
    public int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] += mat[i - 1][j];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] temp = mat[i].clone();
            Arrays.sort(temp);
            for (int j = m - 1; j >= 0; j--) {
                int width = m - j;
                ans = Math.max(ans, temp[j] * width);
            }
        }

        return ans;
    }
}