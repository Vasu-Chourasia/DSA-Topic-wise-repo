import java.util.*;

class Solution
{
    static final int MOD = 1000000007;
    int LOG = 17;
    List<Integer>[] adj;
    int[][] parent;
    int[] depth;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries)
    {
        int n = edges.length + 1;

        adj = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++)
        {
            adj[i] = new ArrayList<>();
        }

        for(int[] e : edges)
        {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        parent = new int[n + 1][LOG];
        depth = new int[n + 1];

        dfs(1, 0);

        for(int j = 1; j < LOG; j++)
        {
            for(int i = 1; i <= n; i++)
            {
                parent[i][j] = parent[parent[i][j - 1]][j - 1];
            }
        }

        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++)
        {
            int u = queries[i][0];
            int v = queries[i][1];

            int lca = lca(u, v);

            int dist = depth[u] + depth[v] - 2 * depth[lca];

            if(dist == 0)
            {
                ans[i] = 0;
            }
            else
            {
                ans[i] = modPow(2, dist - 1);
            }
        }

        return ans;
    }

    void dfs(int node, int par)
    {
        parent[node][0] = par;

        for(int nei : adj[node])
        {
            if(nei != par)
            {
                depth[nei] = depth[node] + 1;
                dfs(nei, node);
            }
        }
    }

    int lca(int u, int v)
    {
        if(depth[u] < depth[v])
        {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for(int i = 0; i < LOG; i++)
        {
            if(((diff >> i) & 1) == 1)
            {
                u = parent[u][i];
            }
        }

        if(u == v)
        {
            return u;
        }

        for(int i = LOG - 1; i >= 0; i--)
        {
            if(parent[u][i] != parent[v][i])
            {
                u = parent[u][i];
                v = parent[v][i];
            }
        }

        return parent[u][0];
    }

    int modPow(int base, int exp)
    {
        long result = 1;
        long b = base;

        while(exp > 0)
        {
            if((exp & 1) == 1)
            {
                result = (result * b) % MOD;
            }

            b = (b * b) % MOD;
            exp >>= 1;
        }

        return (int)result;
    }
}