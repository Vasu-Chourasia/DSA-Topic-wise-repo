import java.util.*;

class Solution {
    public int minSteps(int[] arr, int start, int end) {
        if (start == end) return 0;

        Queue<int[]> q = new LinkedList<>();
        boolean[] vis = new boolean[1000];

        q.offer(new int[]{start, 0});
        vis[start] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int val = cur[0], steps = cur[1];

            for (int num : arr) {
                int next = (val * num) % 1000;

                if (next == end) return steps + 1;

                if (!vis[next]) {
                    vis[next] = true;
                    q.offer(new int[]{next, steps + 1});
                }
            }
        }
        return -1;
    }
}