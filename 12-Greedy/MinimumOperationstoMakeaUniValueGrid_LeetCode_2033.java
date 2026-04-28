import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int[] a = new int[m * n];
        int k = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                a[k++] = grid[i][j];

        int r = a[0] % x;
        for (int v : a)
            if (v % x != r)
                return -1;

        Arrays.sort(a);
        int med = a[a.length / 2];
        int res = 0;

        for (int v : a)
            res += Math.abs(v - med) / x;

        return res;
    }
}