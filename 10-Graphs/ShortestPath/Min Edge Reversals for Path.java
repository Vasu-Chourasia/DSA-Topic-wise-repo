
import java.util.*;

class Solution {
    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        List<int[]>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(new int[]{v, 0});
            adj[v].add(new int[]{u, 1});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Deque<int[]> deque = new ArrayDeque<>();
        dist[src] = 0;
        deque.offerFirst(new int[]{src, 0});

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int u = current[0];
            int d = current[1];

            if (d != dist[u]) {
                continue;
            }

            if (u == dst) {
                return d;
            }

            for (int[] edge : adj[u]) {
                int v = edge[0];
                int cost = edge[1];

                if (d + cost < dist[v]) {
                    dist[v] = d + cost;

                    if (cost == 0) {
                        deque.offerFirst(new int[]{v, dist[v]});
                    } else {
                        deque.offerLast(new int[]{v, dist[v]});
                    }
                }
            }
        }

        return -1;
    }
}