class Solution {
    public char nthCharacter(int n) {
        long digits = 1;
        long count = 9;
        long start = 1;
        while (n > digits * count) {
            n -= digits * count;
            digits++;
            count *= 10;
            start *= 10;
        }
        long number = start + (n - 1) / digits;
        int index = (int) ((n - 1) % digits);

        return Long.toString(number).charAt(index);
    }
}