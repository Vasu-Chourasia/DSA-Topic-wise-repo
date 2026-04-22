import java.util.*;

class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        
        int n = arr.length;
        
        // Step 1: Build prefix sum array
        long[] prefix = new long[n];
        prefix[0] = arr[0];
        
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        // Step 2: Process each query
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            
            // Compute sum using prefix array
            long sum;
            if (l == 0) {
                sum = prefix[r];
            } else {
                sum = prefix[r] - prefix[l - 1];
            }
            
            // Length of subarray
            int len = r - l + 1;
            
            // Compute floor of mean
            int mean = (int)(sum / len);
            
            result.add(mean);
        }
        
        return result;
    }
}