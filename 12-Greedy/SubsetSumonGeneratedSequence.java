class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        long[] paper = new long[arr.length + 1];
        paper[0] = s;
        long sum = s;
        for (int i = 0; i < arr.length; i++) {
            paper[i + 1] = sum + arr[i];
            sum += paper[i + 1];
        }
        long target = x;
        for (int i = paper.length - 1; i >= 0; i--) {
            if (paper[i] <= target) {
                target -= paper[i];
            }
        }
        return target == 0;
    }
}