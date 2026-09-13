class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int[] first = bfs(1, adj);
        int[] second = bfs(first[0], adj);
        return (second[1] + 1) / 2;
    }

    private int[] bfs(int start, ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        dist[start] = 0;

        int farthest = start;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adj.get(current - 1)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[current] + 1;
                    queue.offer(neighbor);

                    if (dist[neighbor] > dist[farthest]) {
                        farthest = neighbor;
                    }
                }
            }
        }

        return new int[]{farthest, dist[farthest]};
    }
}