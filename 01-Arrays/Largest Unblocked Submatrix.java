import java.util.*;

class Solution {
    public int largestArea(int n, int m, int[][] arr) {
        int k = arr.length;
        if (k == 0)
            return n * m;

        int[] rows = new int[k];
        int[] cols = new int[k];

        for (int i = 0; i < k; i++) {
            rows[i] = arr[i][0];
            cols[i] = arr[i][1];
        }

        Arrays.sort(rows);
        Arrays.sort(cols);

        int maxRows = 0;
        int prev = 0;

        for (int r : rows)
        {
            maxRows = Math.max(maxRows, r - prev - 1);
            prev = r;
        }

        maxRows = Math.max(maxRows, n - prev);

        int maxCols = 0;
        prev = 0;

        for (int c : cols)
        {
            maxCols = Math.max(maxCols, c - prev - 1);
            prev = c;
        }

        maxCols = Math.max(maxCols, m - prev);

        return maxRows * maxCols;
    }
}