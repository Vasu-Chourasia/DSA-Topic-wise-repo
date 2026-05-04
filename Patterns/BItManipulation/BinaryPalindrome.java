class Solution {
    public boolean isBinaryPalindrome(int n) {
        int left = 31;  
        int right = 0;

        while (((n >> left) & 1) == 0) {
            left--;
        }
        while (left > right) {
            int leftBit = (n >> left) & 1;
            int rightBit = (n >> right) & 1;

            if (leftBit != rightBit) {
                return false;
            }

            left--;
            right++;
        }

        return true;
    }
}