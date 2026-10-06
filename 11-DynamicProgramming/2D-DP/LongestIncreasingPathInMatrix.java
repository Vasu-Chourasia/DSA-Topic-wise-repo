package 2D-DP;

public class LongestIncreasingPathInMatrix {
    
}
    class Solution {
        public int longIncPath(int[][] matrix, int n, int m) {
            int[][] dp = new int[n][m];
            int answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, dfs(matrix, i, j, dp, n, m));
                }
            }
            return answer;
        }
        private int dfs(int[][] matrix, int i, int j,
                        int[][] dp, int n, int m) {
            if (dp[i][j] != 0) {
                return dp[i][j];
            }
            int maxLength = 1;
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
    
            for (int k = 0; k < 4; k++) {
                int ni = i + dr[k];
                int nj = j + dc[k];
                if (ni >= 0 && ni < n &&
                    nj >= 0 && nj < m &&
                    matrix[ni][nj] > matrix[i][j]) {
                    maxLength = Math.max(
                        maxLength,
                        1 + dfs(matrix, ni, nj, dp, n, m)
                    );
                }
            }
            dp[i][j] = maxLength;
            return dp[i][j];
        }
    }