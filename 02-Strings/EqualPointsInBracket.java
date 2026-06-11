class Solution {
    public int findIndex(String s) {
        int n = s.length();
        int totalClose = 0;

        for (char c : s.toCharArray()) {
            if (c == ')') {
                totalClose++;
            }
        }

        int openCount = 0;

        for (int i = 0; i <= n; i++) {
            if (openCount == totalClose) {
                return i;
            }

            if (i < n) {
                if (s.charAt(i) == '(') {
                    openCount++;
                } else {
                    totalClose--;
                }
            }
        }

        return -1;
    }
}