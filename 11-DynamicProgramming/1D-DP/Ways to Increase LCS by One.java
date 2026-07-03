class Solution {
    public int waysToIncreaseLCSBy1(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] prefix = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    prefix[i][j] = prefix[i - 1][j - 1] + 1;
                }
                else {
                    prefix[i][j] = Math.max(prefix[i - 1][j], prefix[i][j - 1]);
                }
            }
        }

        int originalLCS = prefix[n][m];

        int[][] suffix = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    suffix[i][j] = suffix[i + 1][j + 1] + 1;
                }
                else {
                    suffix[i][j] = Math.max(suffix[i + 1][j], suffix[i][j + 1]);
                }
            }
        }

        int ans = 0;

        for (int pos = 0; pos <= n; pos++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                boolean ok = false;

                for (int j = 0; j < m; j++) {
                    if (s2.charAt(j) == ch) {
                        if (prefix[pos][j] + suffix[pos][j + 1] == originalLCS) {
                            ok = true;
                            break;
                        }
                    }
                }

                if (ok) {
                    ans++;
                }
            }
        }

        return ans;
    }
}