
class Solution {
    public ArrayList<Integer> countVowels(String s, int[][] queries) {
        int n = s.length();
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            prefix[i + 1] = prefix[i];

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                prefix[i + 1]++;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];

            result.add(prefix[r + 1] - prefix[l]);
        }

        return result;
    }
}
