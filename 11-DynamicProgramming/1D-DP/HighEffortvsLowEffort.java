class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;
        int prev2 = 0;
        int prev1 = Math.max(h[0], l[0]);
        for (int i = 1; i < n; i++) {
            int low = prev1 + l[i];
            int high = prev2 + h[i];
            int curr = Math.max(low, Math.max(high, prev1));
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}