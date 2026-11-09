class Solution {
    int getCount(String s, int k) {
        int[] freq = new int[26];
        freq[s.charAt(0) - 'a']++;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                freq[s.charAt(i) - 'a']++;
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == k) {
                count++;
            }
        }
        return count;
    }
}
