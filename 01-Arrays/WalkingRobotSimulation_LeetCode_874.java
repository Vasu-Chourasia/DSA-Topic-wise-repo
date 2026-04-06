import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {

        // Step 1: Store obstacles in HashSet
        Set<String> set = new HashSet<>();
        for (int[] obs : obstacles) {
            set.add(obs[0] + "#" + obs[1]);
        }

        // Directions: N, E, S, W
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int dir = 0; // start facing North

        int x = 0, y = 0;
        int maxDist = 0;

        // Step 2: Process commands
        for (int cmd : commands) {

            if (cmd == -1) {
                // Turn right
                dir = (dir + 1) % 4;

            } else if (cmd == -2) {
                // Turn left
                dir = (dir + 3) % 4;

            } else {
                // Move forward step-by-step
                for (int i = 0; i < cmd; i++) {

                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];

                    // Check obstacle
                    if (set.contains(nx + "#" + ny)) {
                        break;
                    }

                    x = nx;
                    y = ny;

                    // Update max distance
                    maxDist = Math.max(maxDist, x*x + y*y);
                }
            }
        }

        return maxDist;
    }
}