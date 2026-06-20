import java.util.*;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 0});
        for (int[] r : restrictions)
        {
            list.add(r);
        }
        list.add(new int[]{n, n - 1});
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < list.size(); i++)
        {
            int[] prev = list.get(i - 1);
            int[] curr = list.get(i);
            curr[1] = Math.min(curr[1], prev[1] + (curr[0] - prev[0]));
        }
        for (int i = list.size() - 2; i >= 0; i--)
        {
            int[] next = list.get(i + 1);
            int[] curr = list.get(i);
            curr[1] = Math.min(curr[1], next[1] + (next[0] - curr[0]));
        }
        int ans = 0;
        for (int i = 1; i < list.size(); i++)
        {
            int[] a = list.get(i - 1);
            int[] b = list.get(i);
            int dist = b[0] - a[0];
            int h1 = a[1];
            int h2 = b[1];
            int peak = (h1 + h2 + dist) / 2;
            ans = Math.max(ans, peak);
        }
        return ans;
    }
}