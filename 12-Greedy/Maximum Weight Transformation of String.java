class Solution {
    public int getMaxWeight(String s) {
        int n = s.length();
        int prev2 = 0;
        int prev1 = 0;
        for (int i = 1; i <= n; i++) {
            int single = prev1 + 1;
            int curr = single;
            if (i >= 2) {
                int cost = (s.charAt(i - 2) == s.charAt(i - 1)) ? 1 : 0;
                int pair = prev2 + 4 - cost;
                curr = Math.max(single, pair);
            }
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}