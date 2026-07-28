import java.util.*;

class Solution {
    static class Edge {
        int node, weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static class Pair {
        int node, dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int shortestPath(int V, int src, int dest, int[][] edges) {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        distance[src] = 0;
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            if (current.dist > distance[current.node]) {
                continue;
            }

            for (Edge next : graph.get(current.node)) {
                int newDistance = current.dist + next.weight;

                if (newDistance < distance[next.node]) {
                    distance[next.node] = newDistance;
                    pq.offer(new Pair(next.node, newDistance));
                }
            }
        }

        return distance[dest] == Integer.MAX_VALUE ? -1 : distance[dest];
    }
}