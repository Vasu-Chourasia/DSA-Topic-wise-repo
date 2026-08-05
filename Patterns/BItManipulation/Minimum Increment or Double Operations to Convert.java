class Solution {
    public int countMinOperations(int arr[]) {
        int increments = 0;
        int max = 0;

        for (int num : arr) {
            increments += Integer.bitCount(num);
            if (num > max) {
                max = num;
            }
        }

        if (max == 0) {
            return 0;
        }

        int doubles = 31 - Integer.numberOfLeadingZeros(max);

        return increments + doubles;
    }
}