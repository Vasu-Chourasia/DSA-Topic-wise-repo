
class Solution {
    public boolean isItPossible(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) return false;

        int i = 0, j = 0;

        while (i < n && j < n) {
            while (i < n && s1.charAt(i) == '#') i++;
            while (j < n && s2.charAt(j) == '#') j++;

            if (i == n || j == n) return i == n && j == n;
            if (s1.charAt(i) != s2.charAt(j)) return false;
            if (s1.charAt(i) == 'A' && j > i) return false;
            if (s1.charAt(i) == 'B' && j < i) return false;

            i++;
            j++;
        }

        return true;
    }
}
