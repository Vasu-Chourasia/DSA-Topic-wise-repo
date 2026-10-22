
class Solution {
    public int minSubarraySum(int[] arr) {
        int currSum = arr[0];
        int minSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currSum = Math.min(arr[i], currSum + arr[i]);
            minSum = Math.min(minSum, currSum);
        }

        return minSum;
    }
}
