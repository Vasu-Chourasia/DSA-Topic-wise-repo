public class solution {
    
}
import java.util.*;

class Solution {
    class State {
        int x, y, energy, mask, dist;

        State(int x, int y, int energy, int mask, int dist) {
            this.x = x;
            this.y = y;
            this.energy = energy;
            this.mask = mask;
            this.dist = dist;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sx = 0, sy = 0;

        Map<Integer, Integer> litterIndex = new HashMap<>();
        int idx = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    sx = i;
                    sy = j;
                } else if (c == 'L') {
                    litterIndex.put(i * n + j, idx++);
                }
            }
        }

        int fullMask = (1 << idx) - 1;

        boolean[][][][] vis = new boolean[m][n][energy + 1][1 << idx];

        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(sx, sy, energy, 0, 0));
        vis[sx][sy][energy][0] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.mask == fullMask)
                return cur.dist;

            if (cur.energy == 0 && classroom[cur.x].charAt(cur.y) != 'R')
                continue;

            int currentEnergy = cur.energy;
            if (classroom[cur.x].charAt(cur.y) == 'R')
                currentEnergy = energy;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                    continue;

                char cell = classroom[nx].charAt(ny);

                if (cell == 'X')
                    continue;

                int nextEnergy = currentEnergy - 1;
                if (nextEnergy < 0)
                    continue;

                int nextMask = cur.mask;

                if (cell == 'L') {
                    int id = litterIndex.get(nx * n + ny);
                    nextMask |= (1 << id);
                }

                if (cell == 'R')
                    nextEnergy = energy;

                if (!vis[nx][ny][nextEnergy][nextMask]) {
                    vis[nx][ny][nextEnergy][nextMask] = true;
                    q.offer(new State(nx, ny, nextEnergy, nextMask, cur.dist + 1));
                }
            }
        }

        return -1;
    }
}