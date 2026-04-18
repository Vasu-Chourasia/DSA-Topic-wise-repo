class Solution {
    int maxOnes(int[] arr) {
        
        int totalOnes = 0;
        
        // Step 1: Count total 1s
        for (int num : arr) {
            if (num == 1) totalOnes++;
        }
        
        // Step 2: Apply Kadane on transformed array
        int maxGain = 0;   // maximum subarray sum
        int currentGain = 0;
        
        for (int num : arr) {
            
            // Transform:
            // 0 -> +1 (gain)
            // 1 -> -1 (loss)
            int val = (num == 0) ? 1 : -1;
            
            currentGain = Math.max(val, currentGain + val);
            maxGain = Math.max(maxGain, currentGain);
        }
        
        // Step 3: Result
        return totalOnes + maxGain;
    }
}