import java.util.Arrays;

class Solution {
    public static int countPairs(int arr[], int k) {
        if (k <= 0) {
            return 0;
        }

        Arrays.sort(arr);

        int n = arr.length;
        int left = 0;
        int count = 0;

        for (int right = 0; right < n; right++) {
            while (arr[right] - arr[left] >= k) {
                left++;
            }
            count += right - left;
        }

        return count;
    }
}