
class Solution {
    public String findRollOut(String s, int[] roll) {
        char[] arr = s.toCharArray();
        int[] count = new int[arr.length];

        for (int r : roll) {
            count[r - 1]++;
        }

        int shift = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            shift = (shift + count[i]) % 26;
            arr[i] = (char) ('a' + (arr[i] - 'a' + shift) % 26);
        }

        return new String(arr);
    }
}
