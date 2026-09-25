import java.util.*;

class Solution {
    public int maxHeight(int[] height, int[] width, int[] length) {
        int n = height.length;
        int[][] boxes = new int[3 * n][3];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            boxes[idx++] = new int[]{height[i], Math.max(width[i], length[i]), Math.min(width[i], length[i])};
            boxes[idx++] = new int[]{width[i], Math.max(height[i], length[i]), Math.min(height[i], length[i])};
            boxes[idx++] = new int[]{length[i], Math.max(height[i], width[i]), Math.min(height[i], width[i])};
        }

        Arrays.sort(boxes, (a, b) -> {
            int cmp = Integer.compare(b[1], a[1]);
            if (cmp == 0) {
                cmp = Integer.compare(b[2], a[2]);
            }
            return cmp;
        });

        int m = boxes.length;
        int[] dp = new int[m];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            dp[i] = boxes[i][0];

            for (int j = 0; j < i; j++) {
                if (boxes[j][1] > boxes[i][1] &&
                    boxes[j][2] > boxes[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + boxes[i][0]);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}