
class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] edge : dependencies) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                dp[i] = duration[i];
            }
        }
        int count = 0;
        int ans = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            count++;
            ans = Math.max(ans, dp[u]);
            for (int v : adj.get(u)) {
                dp[v] = Math.max(dp[v], dp[u] + duration[v]);
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return count == n ? ans : -1;
    }
}