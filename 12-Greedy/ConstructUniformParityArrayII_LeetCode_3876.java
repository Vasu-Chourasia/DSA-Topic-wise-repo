import java.util.*;
class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        boolean[] canEven = new boolean[n];
        boolean[] canOdd = new boolean[n];
        boolean seenEven = false;
        boolean seenOdd = false;
        for (int[] x : arr) {
            int val = x[0];
            int idx = x[1];
            if ((val & 1) == 0) {
                canEven[idx] = true;
                if (seenEven) canEven[idx] = true;
                if (seenOdd) canOdd[idx] = true;

                seenEven = true;
            } else {
                canOdd[idx] = true;
                if (seenOdd) canEven[idx] = true;
                if (seenEven) canOdd[idx] = true;

                seenOdd = true;
            }
        }
        boolean allEven = true;
        boolean allOdd = true;
        for (int i = 0; i < n; i++) {
            if (!canEven[i]) allEven = false;
            if (!canOdd[i]) allOdd = false;
        }
        return allEven || allOdd;
    }
}