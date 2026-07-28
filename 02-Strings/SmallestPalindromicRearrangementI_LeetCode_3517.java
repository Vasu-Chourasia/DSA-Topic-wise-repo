class Solution {
    public String smallestPalindrome(String s) {
        int[] frequency = new int[26];

        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }

        StringBuilder firstHalf = new StringBuilder();
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if ((frequency[i] & 1) == 1) {
                middle = (char) ('a' + i);
            }

            for (int j = 0; j < frequency[i] / 2; j++) {
                firstHalf.append((char) ('a' + i));
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(firstHalf);

        if (middle != 0) {
            answer.append(middle);
        }

        answer.append(firstHalf.reverse());

        return answer.toString();
    }
}