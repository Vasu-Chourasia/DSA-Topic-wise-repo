class Solution {
    public int largestSumCycle(int[] edge) {
        int n = edge.length;
        boolean[] visited = new boolean[n];
        int[] time = new int[n];

        int maxSum = -1;
        int timer = 1;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            int curr = i;

            while (curr != -1 && !visited[curr]) {
                visited[curr] = true;
                time[curr] = timer++;
                curr = edge[curr];
            }

            // Cycle detected in the current traversal
            if (curr != -1 && time[curr] >= time[i]) {
                int cycleSum = 0;
                int node = curr;

                do {
                    cycleSum += node;
                    node = edge[node];
                } while (node != curr);

                maxSum = Math.max(maxSum, cycleSum);
            }
        }

        return maxSum;
    }
}