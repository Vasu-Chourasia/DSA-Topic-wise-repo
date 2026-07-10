class Solution {
    public int getCount(int n) {
        // code here
        int count = 0;
        for (int len = 2; (long) len * (len + 1) / 2 <= n; len++) {
            int rem = n - (len * (len - 1)) / 2;
            if (rem > 0 && rem % len == 0) {
                count++;
            }
        }
        return count;
    }
};