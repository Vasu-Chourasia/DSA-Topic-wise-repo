class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        // build graph
        for(int[] p : prerequisites){
            int x = p[0];
            int y = p[1];

            graph.get(y).add(x); // y → x
            indegree[x]++;
        }

        // queue for nodes with indegree 0
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int count = 0;

        // BFS
        while(!q.isEmpty()){
            int node = q.poll();
            count++;

            for(int neighbor : graph.get(node)){
                indegree[neighbor]--;

                if(indegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }

        return count == n;
    }
}