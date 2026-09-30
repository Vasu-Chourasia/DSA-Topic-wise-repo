class Solution {
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        if (knightPos[0] == targetPos[0] && knightPos[1] == targetPos[1])
            return 0;
        int[][] dir = {
            {2,1},{2,-1},{-2,1},{-2,-1},
            {1,2},{1,-2},{-1,2},{-1,-2}
        };
        boolean[][] visited = new boolean[n + 1][n + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{knightPos[0], knightPos[1], 0});
        visited[knightPos[0]][knightPos[1]] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];
            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && !visited[nx][ny]) {
                    if (nx == targetPos[0] && ny == targetPos[1])
                        return dist + 1;
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }

        return -1;
    }
}