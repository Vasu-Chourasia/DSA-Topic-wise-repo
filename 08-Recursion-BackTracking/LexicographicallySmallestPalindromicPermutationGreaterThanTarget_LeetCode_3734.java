class Solution {
    int n, halfLen;
    int[] cnt;
    char[] half;
    char mid;
    String target;

    public String lexPalindromicPermutation(String s, String target) {
        this.n = s.length();
        this.target = target;

        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        int odd = 0;
        mid = 0;
        cnt = new int[26];

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                odd++;
                mid = (char) ('a' + i);
            }
            cnt[i] = freq[i] / 2;
        }

        if (odd > 1) return "";

        halfLen = n / 2;
        half = new char[halfLen];

        if (!dfs(0, 0)) return "";

        StringBuilder ans = new StringBuilder();
        ans.append(half);
        if ((n & 1) == 1) ans.append(mid);
        for (int i = halfLen - 1; i >= 0; i--) ans.append(half[i]);
        return ans.toString();
    }

    // relation:
    // 0 -> equal so far
    // 1 -> already greater
    // -1 -> already smaller (invalid)
    boolean dfs(int pos, int relation) {
        if (relation == -1) return false;

        if (pos == halfLen) {
            int rel = relation;

            if ((n & 1) == 1 && rel == 0) {
                char t = target.charAt(halfLen);
                if (mid > t) rel = 1;
                else if (mid < t) rel = -1;
            }

            for (int i = halfLen - 1; i >= 0 && rel == 0; i--) {
                char c = half[i];
                char t = target.charAt(n - 1 - i);
                if (c > t) rel = 1;
                else if (c < t) rel = -1;
            }

            return rel == 1;
        }

        for (int ch = 0; ch < 26; ch++) {
            if (cnt[ch] == 0) continue;

            char c = (char) ('a' + ch);

            int nextRel = relation;
            if (relation == 0) {
                char t = target.charAt(pos);
                if (c > t) nextRel = 1;
                else if (c < t) nextRel = -1;
            }

            cnt[ch]--;
            half[pos] = c;

            if (dfs(pos + 1, nextRel)) return true;

            cnt[ch]++;
        }

        return false;
    }
}