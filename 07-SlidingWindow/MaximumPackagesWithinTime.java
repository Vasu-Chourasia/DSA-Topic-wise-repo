class Solution {
    public int maxPackages(int[] arr, int totalTime) {
        int n = arr.length;
        int k = Math.min(totalTime, n);
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        int maxPackages = windowSum;
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            maxPackages = Math.max(maxPackages, windowSum);
        }
        return maxPackages;
    }
}