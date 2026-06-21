import java.util.*;

class Solution {
    public String chooseSwap(String s) {
        int n = s.length();
        int[] first = new int[26];
        Arrays.fill(first, -1);

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (first[idx] == -1) {
                first[idx] = i;
            }
        }

        char[] arr = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int curr = arr[i] - 'a';

            for (int ch = 0; ch < curr; ch++) {
                if (first[ch] > i) {
                    char c1 = (char)(curr + 'a');
                    char c2 = (char)(ch + 'a');

                    for (int j = 0; j < n; j++) {
                        if (arr[j] == c1) {
                            arr[j] = c2;
                        } else if (arr[j] == c2) {
                            arr[j] = c1;
                        }
                    }

                    return new String(arr);
                }
            }
        }

        return s;
    }
}