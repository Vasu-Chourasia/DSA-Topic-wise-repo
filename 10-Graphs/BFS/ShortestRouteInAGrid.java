class Solution {
    int shortestPath(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (isSafe(mat, i, 0)) {
                q.add(new int[]{i, 0, 1});
                mat[i][0] = -1;
            }
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], dist = curr[2];
            if (c == m - 1) return dist;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                    isSafe(mat, nr, nc)) {
                    q.add(new int[]{nr, nc, dist + 1});
                    mat[nr][nc] = -1;
                }
            }
        }
        return -1;
    }

    private boolean isSafe(int[][] mat, int r, int c) {
        int n = mat.length, m = mat[0].length;

        if (mat[r][c] != 1) return false;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k], nc = c + dc[k];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                mat[nr][nc] == 0) {
                return false;
            }
        }

        return true;
    }
}