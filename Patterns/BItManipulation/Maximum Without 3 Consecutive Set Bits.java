class Solution {
    public int maxValue(int n) {
        int res = n;
        for (int i = 30; i >= 2; --i) {
            if ((res & (1 << i)) != 0
                && (res & (1 << (i - 1))) != 0
                && (res & (1 << (i - 2))) != 0) {
                    
                res &= ~(1 << (i - 2));
            }
        }
        return res;
    }
}