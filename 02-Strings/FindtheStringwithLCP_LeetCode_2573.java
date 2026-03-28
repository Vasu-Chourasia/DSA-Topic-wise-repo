import java.util.*;

class Solution {

    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        // Step 1: Check diagonal condition
        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) {
                return "";
            }
        }

        // Step 2: Build string using greedy grouping
        char[] word = new char[n];
        Arrays.fill(word, '#'); // unassigned

        char ch = 'a';

        for (int i = 0; i < n; i++) {
            if (word[i] == '#') {
                if (ch > 'z') return ""; // more than 26 groups

                // assign new character
                for (int j = i; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        word[j] = ch;
                    }
                }
                ch++;
            }
        }

        // Step 3: Validate by recomputing LCP
        int[][] calc = new int[n][n];

        // fill from bottom-right (DP)
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (word[i] == word[j]) {
                    if (i == n - 1 || j == n - 1) {
                        calc[i][j] = 1;
                    } else {
                        calc[i][j] = 1 + calc[i + 1][j + 1];
                    }
                } else {
                    calc[i][j] = 0;
                }
            }
        }

        // Step 4: Compare with given LCP
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (calc[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }

        return new String(word);
    }
}