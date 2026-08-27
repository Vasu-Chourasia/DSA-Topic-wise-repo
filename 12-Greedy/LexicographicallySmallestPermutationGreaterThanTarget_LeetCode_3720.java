class Solution {
    int[] freq;
    char[] target;
    StringBuilder ans;

    public String lexGreaterPermutation(String s, String t) {
        freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        target = t.toCharArray();
        ans = new StringBuilder();

        if (dfs(0, false))
            return ans.toString();
        return "";
    }

    private boolean dfs(int idx, boolean greater) {
        if (idx == target.length)
            return greater;

        if (greater) {
            for (int c = 0; c < 26; c++) {
                while (freq[c] > 0) {
                    ans.append((char) (c + 'a'));
                    freq[c]--;
                }
            }
            return true;
        }

        int cur = target[idx] - 'a';

        // Try equal character first
        if (freq[cur] > 0) {
            freq[cur]--;
            ans.append((char) (cur + 'a'));

            if (dfs(idx + 1, false))
                return true;

            ans.deleteCharAt(ans.length() - 1);
            freq[cur]++;
        }

        // Try next greater character
        for (int c = cur + 1; c < 26; c++) {
            if (freq[c] == 0)
                continue;

            freq[c]--;
            ans.append((char) (c + 'a'));

            while (idx + 1 < target.length) {
                for (int k = 0; k < 26; k++) {
                    while (freq[k] > 0) {
                        ans.append((char) (k + 'a'));
                        freq[k]--;
                    }
                }
                break;
            }

            return true;
        }

        return false;
    }
}