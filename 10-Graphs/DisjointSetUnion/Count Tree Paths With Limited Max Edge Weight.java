
import java.util.*;

class Solution {
    int[] parent, size;

    public ArrayList<Integer> maximumWeight(int n, int[][] edges, int[] queries) {
        ArrayList<Integer> ans = new ArrayList<>();
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int[][] sq = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sq[i][0] = queries[i];
            sq[i][1] = i;
        }

        Arrays.sort(sq, (a, b) -> Integer.compare(a[0], b[0]));

        int[] res = new int[queries.length];
        int idx = 0;
        long total = 0;

        for (int[] query : sq) {
            int x = query[0];
            int qi = query[1];

            while (idx < edges.length && edges[idx][2] <= x) {
                int u = find(edges[idx][0]);
                int v = find(edges[idx][1]);

                if (u != v) {
                    total += (long) size[u] * size[v];
                    union(u, v);
                }
                idx++;
            }

            res[qi] = (int) total;
        }

        for (int val : res) ans.add(val);
        return ans;
    }

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int u, int v) {
        if (size[u] < size[v]) {
            int t = u;
            u = v;
            v = t;
        }
        parent[v] = u;
        size[u] += size[v];
    }
}
