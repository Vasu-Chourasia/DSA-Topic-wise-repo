import java.util.*;

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;

        long[] pos = new long[n];
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];

            if (y == 0) pos[i] = x;
            else if (x == side) pos[i] = side + y;
            else if (y == side) pos[i] = 3L * side - x;
            else pos[i] = 4L * side - y;
        }

        Arrays.sort(pos);

        long perimeter = 4L * side;

        long[] extended = new long[2 * n];
        for (int i = 0; i < n; i++) {
            extended[i] = pos[i];
            extended[i + n] = pos[i] + perimeter;
        }

        long low = 0, high = 2L * side, ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (canPick(extended, n, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int) ans;
    }

    private boolean canPick(long[] arr, int n, int k, long d) {
        for (int start = 0; start < n; start++) {
            int count = 1;
            long last = arr[start];

            for (int i = start + 1; i < start + n && count < k; i++) {
                if (arr[i] - last >= d) {
                    count++;
                    last = arr[i];
                }
            }

            if (count >= k) return true;
        }
        return false;
    }
}