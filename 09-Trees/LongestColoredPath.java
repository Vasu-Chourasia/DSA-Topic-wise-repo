import java.util.*;
class Solution {
    public void root(List<List<Integer>> adj, String s, int[][] sa, int node, int par) {
        int ra = 0, ba = 0;
        for (int it : adj.get(node)) {
            if (it == par)
                continue;
            root(adj, s, sa, it, node);
            ra = Math.max(ra, sa[it][0]);
            ra = Math.max(ra, sa[it][1]);
            ba = Math.max(ba, sa[it][1]);
        }
        if (s.charAt(node) == 'R') {
            sa[node][0] = ra + 1;
            sa[node][1] = 0;
        } else {
            sa[node][0] = ba + 1;
            sa[node][1] = ba + 1;
        }
    }
    public void reroot(List<List<Integer>> adj, String s, int[][] ans,
                       int[][] sa, int node, int par,
                       int redPar, int bluePar) {
        if (s.charAt(node) == 'R') {
            ans[node][0] = Math.max(sa[node][0], 1 + redPar);
            ans[node][1] = 0;
        } else {
            ans[node][0] = Math.max(sa[node][0], 1 + bluePar);
            ans[node][1] = Math.max(sa[node][1], 1 + bluePar);
        }
        int fr = redPar, sr = redPar;
        int fb = bluePar, sb = bluePar;
        for (int it : adj.get(node)) {
            if (it == par)
                continue;
            if (sa[it][0] > fr) {
                sr = fr;
                fr = sa[it][0];
            } else if (sa[it][0] > sr) {
                sr = sa[it][0];
            }
            if (sa[it][1] > fb) {
                sb = fb;
                fb = sa[it][1];
            } else if (sa[it][1] > sb) {
                sb = sa[it][1];
            }
        }
        for (int it : adj.get(node)) {
            if (it == par)
                continue;
            int newRed = 0, newBlue = 0;
            if (s.charAt(node) == 'R') {
                newRed = 1;
                if (sa[it][0] == fr)
                    newRed += sr;
                else
                    newRed += fr;
            } else {
                newRed = 1;

                if (sa[it][1] == fb)
                    newRed += sb;
                else
                    newRed += fb;

                newBlue = newRed;
            }
            reroot(adj, s, ans, sa, it, node, newRed, newBlue);
        }
    }
    public int longestPath(String s, int[][] edges) {
        int n = s.length();

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[][] subTreeAns = new int[n][2];
        root(adj, s, subTreeAns, 0, -1);
        int[][] ans = new int[n][2];
        reroot(adj, s, ans, subTreeAns, 0, -1, 0, 0);
        int res = 0;
        for (int i = 0; i < n; i++)
            res = Math.max(res, Math.max(ans[i][0], ans[i][1]));

        return res;
    }
}