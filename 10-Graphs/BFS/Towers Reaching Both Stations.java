class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int countCoordinates(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] p = new boolean[n][m];
        boolean[][] q = new boolean[n][m];

        for (int i = 0; i < n; i++)
        {
            dfs(mat, p, i, 0);
            dfs(mat, q, i, m - 1);
        }

        for (int j = 0; j < m; j++)
        {
            dfs(mat, p, 0, j);
            dfs(mat, q, n - 1, j);
        }

        int ans = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (p[i][j] && q[i][j])
                {
                    ans++;
                }
            }
        }

        return ans;
    }

    void dfs(int[][] mat, boolean[][] vis, int r, int c) {
        if (vis[r][c])
        {
            return;
        }

        vis[r][c] = true;
        int n = mat.length;
        int m = mat[0].length;

        for (int k = 0; k < 4; k++)
        {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m)
            {
                if (!vis[nr][nc] && mat[nr][nc] >= mat[r][c])
                {
                    dfs(mat, vis, nr, nc);
                }
            }
        }
    }
}