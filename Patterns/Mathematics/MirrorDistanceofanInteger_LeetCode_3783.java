class Solution {
    public int mirrorDistance(int n) {
        
        int original = n;  // store original number
        int reversed = 0;
    
        while (n > 0) {
            int digit = n % 10;   
            reversed = reversed * 10 + digit; // build reversed number
            n /= 10;                  // remove last digit
        }
        return Math.abs(original - reversed);
    }
}