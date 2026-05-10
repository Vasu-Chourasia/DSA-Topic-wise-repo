import java.util.*;

class Solution {
    public int maxProfit(int x, int y, int[] a, int[] b) {
        int n = a.length;
        Integer[] idx = new Integer[n];
        
        for (int i = 0; i < n; i++) idx[i] = i;
        
        Arrays.sort(idx, (i, j) -> Math.abs(a[j] - b[j]) - Math.abs(a[i] - b[i]));
        
        int profit = 0;
        
        for (int i : idx) {
            if ((a[i] >= b[i] && x > 0) || y == 0) {
                profit += a[i];
                x--;
            } else {
                profit += b[i];
                y--;
            }
        }
        
        return profit;
    }
}