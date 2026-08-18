class Solution {
    static void computeLPS(String s, int[] lps) {
        int n = s.length();
        lps[0] = 0;
        for (int i = 1; i < n; i++) {
            int len = lps[i - 1];
            while (len > 0 && s.charAt(i) != s.charAt(len)) {
                len = lps[len - 1];
            }
            if (s.charAt(i) == s.charAt(len)) {
                len++;
            }
            lps[i] = len;
        }
    }
    public String compress(String s) {
        int n = s.length();
        int[] lps = new int[n];
        computeLPS(s, lps);
        Stack<Character> st = new Stack<>();
        for (int i = n - 1; i > 0; i--) {
            int len = i + 1;
            if (len % 2 == 1) {
                st.push(s.charAt(i));
                continue;
            }
            int longestPrefixSuffix = lps[i];
            int blockLength = len - longestPrefixSuffix;
            boolean canCompress = false;
            if (longestPrefixSuffix * 2 >= len
                && len % blockLength == 0
                && (len / blockLength) % 2 == 0) {
                canCompress = true;
            }
            if (canCompress) {
                st.push('*');
                i = len / 2;
            } else {
                st.push(s.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.toString();
    }
}