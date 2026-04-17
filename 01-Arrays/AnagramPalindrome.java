class Solution {
    public boolean canFormPalindrome(String s) {
        int[] freq = new int[26];

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int oddCount = 0;

        // Count how many characters have odd frequency
        for (int f : freq) {
            if (f % 2 != 0) {
                oddCount++;
            }
        }

        // Palindrome condition
        return oddCount <= 1;
    }
}