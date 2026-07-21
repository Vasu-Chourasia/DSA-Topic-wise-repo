class Solution {
    public int maxIndexDifference(String s) {
        int n = s.length();
        int[] maxReachForChar = new int[26];

        for (int i = 0; i < 26; i++) {
            maxReachForChar[i] = -1;
        }

        int ans = -1;

        for (int i = n - 1; i >= 0; i--) {
            int ch = s.charAt(i) - 'a';
            int best;

            if (ch == 25 || maxReachForChar[ch + 1] == -1) {
                best = i;
            } else {
                best = maxReachForChar[ch + 1];
            }

            if (ch == 0) {
                ans = Math.max(ans, best - i);
            }

            if (best > maxReachForChar[ch]) {
                maxReachForChar[ch] = best;
            }
        }

        return ans;
    }
}