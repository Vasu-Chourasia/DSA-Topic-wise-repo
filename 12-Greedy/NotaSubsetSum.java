import java.util.*;

class Solution {
    public int findSmallest(int[] arr) {
        Arrays.sort(arr);
        long res = 1;

        for (int x : arr) {
            if (x > res) break;
            res += x;
        }

        return (int)res;
    }
}