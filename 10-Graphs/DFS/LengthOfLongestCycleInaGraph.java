class Solution {
    int maxCycle = -1;

    public int longestCycle(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
        }

        boolean[] visited = new boolean[V];
        boolean[] inPath = new boolean[V];
        int[] time = new int[V];

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(i, graph, visited, inPath, time, 0);
            }
        }

        return maxCycle;
    }

    private void dfs(int node, List<List<Integer>> graph,
                     boolean[] visited, boolean[] inPath,
                     int[] time, int currTime){

        visited[node] = true;
        inPath[node] = true;
        time[node] = currTime;

        for(int nei : graph.get(node)){
            if(!visited[nei]){
                dfs(nei, graph, visited, inPath, time, currTime + 1);
            }
            else if(inPath[nei]){
                maxCycle = Math.max(maxCycle, currTime - time[nei] + 1);
            }
        }

        inPath[node] = false;
    }
}