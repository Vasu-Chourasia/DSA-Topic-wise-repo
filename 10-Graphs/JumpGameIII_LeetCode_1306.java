import java.util.*;

class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (arr[curr] == 0) {
                return true;
            }
            int forward = curr + arr[curr];
            if (forward < n && !visited[forward]) {
                queue.add(forward);
                visited[forward] = true;
            }
            int backward = curr - arr[curr];
            if (backward >= 0 && !visited[backward]) {
                queue.add(backward);
                visited[backward] = true;
            }
        }

        return false; 
    }
}