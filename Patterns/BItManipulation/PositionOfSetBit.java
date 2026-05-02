class Solution {
    static int findPosition(int n) {
        if (n == 0) return -1;
        if ((n & (n - 1)) != 0) return -1;
        int position = 1;

        while (n > 1) {
            n >>= 1; 
            position++;
        }

        return position;
    }
}