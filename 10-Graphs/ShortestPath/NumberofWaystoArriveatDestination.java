class Solution {
    public int countPaths(int V, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];
            
            adj.get(u).add(new int[]{v, time});
            adj.get(v).add(new int[]{u, time});
        }
        
        // Step 2: Min Heap -> {time, node}
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );
        
        // Step 3: Distance & Ways array
        long[] dist = new long[V];
        int[] ways = new int[V];
        
        Arrays.fill(dist, Long.MAX_VALUE);
        
        dist[0] = 0;
        ways[0] = 1;
        
        pq.offer(new long[]{0, 0}); // {time, node}
        
        int MOD = (int)1e9 + 7;
        
        // Step 4: Dijkstra
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long currTime = curr[0];
            int node = (int)curr[1];
            
            // Skip outdated entries
            if (currTime > dist[node]) continue;
            
            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int travelTime = neighbor[1];
                
                long newTime = currTime + travelTime;
                
                // Case 1: Found shorter path
                if (newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;
                    ways[nextNode] = ways[node]; // inherit ways
                    pq.offer(new long[]{newTime, nextNode});
                }
                
                // Case 2: Found another shortest path
                else if (newTime == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }
        
        return ways[V - 1];
    }
}
