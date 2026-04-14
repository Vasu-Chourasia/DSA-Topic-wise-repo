class Solution {
    String removeSpaces(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                result.append(ch);
            }
        }
        return result.toString();
    }
}