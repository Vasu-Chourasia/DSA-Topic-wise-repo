class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        String t = "1" + s + "1";
        int n = t.length();

        ArrayList<Character> ch = new ArrayList<>();
        ArrayList<Integer> len = new ArrayList<>();

        int i = 0;

        while (i < n) {
            char c = t.charAt(i);
            int j = i;

            while (j < n && t.charAt(j) == c) {
                j++;
            }

            ch.add(c);
            len.add(j - i);
            i = j;
        }

        int ones = 0;

        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        int ans = ones;

        for (i = 1; i + 1 < ch.size(); i++) {
            if (ch.get(i) == '1'
                && ch.get(i - 1) == '0'
                && ch.get(i + 1) == '0') {

                ans = Math.max(ans, ones + len.get(i - 1) + len.get(i + 1));
            }
        }

        return ans;
    }
}