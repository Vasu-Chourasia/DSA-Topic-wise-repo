import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        ArrayList<int[]>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxCost = 0;

        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            indegree[edge[1]]++;
            maxCost = Math.max(maxCost, edge[2]);
        }

        int[] topo = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int idx = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;

            for (int[] e : graph[u]) {
                indegree[e[0]]--;

                if (indegree[e[0]] == 0) {
                    q.offer(e[0]);
                }
            }
        }

        int low = 0;
        int high = maxCost;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(mid, graph, topo, online, k)) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int limit, ArrayList<int[]>[] graph, int[] topo, boolean[] online, long k) {
        int n = online.length;
        long INF = Long.MAX_VALUE / 4;

        long[] dp = new long[n];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int u : topo) {
            if (dp[u] == INF) {
                continue;
            }

            if (u != 0 && u != n - 1 && !online[u]) {
                continue;
            }

            for (int[] e : graph[u]) {
                int v = e[0];
                int cost = e[1];

                if (cost < limit) {
                    continue;
                }

                if (v != n - 1 && !online[v]) {
                    continue;
                }

                dp[v] = Math.min(dp[v], dp[u] + cost);
            }
        }

        return dp[n - 1] <= k;
    }
}