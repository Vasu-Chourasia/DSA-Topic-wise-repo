Count increasing Subarrays
class Solution {
    public int countIncreasing(int[] arr) {
        int n = arr.length;
        
        int len = 1;   // length of current increasing subarray
        int count = 0; // final answer
        
        for (int i = 1; i < n; i++) {
            // If strictly increasing
            if (arr[i] > arr[i - 1]) {
                len++; // extend streak
            } else {
                len = 1; // reset streak
            }
            
            // Add number of new subarrays ending at i
            count += (len - 1);
        }
        
        return count;
    }
}