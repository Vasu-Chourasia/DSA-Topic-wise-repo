class Solution {
    int maxSubstring(String s) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        
        boolean hasZero = false;
        
        for (int i = 0; i < s.length(); i++) {
            int value;
            if (s.charAt(i) == '0') {
                value = 1;
                hasZero = true;
            } else {
                value = -1;
            }
            currentSum += value;
            
            if (currentSum < value) {
                currentSum = value;
            }
            
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        if (!hasZero) return -1;
        
        return maxSum;
    }
}