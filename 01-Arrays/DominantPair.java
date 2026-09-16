class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length / 2;

        Arrays.sort(arr, 0, n);
        Arrays.sort(arr, n, arr.length);

        int count = 0;
        int j = arr.length - 1;
        int i = n - 1;

        while (j >= n) {
            while (i >= 0 && (long) arr[i] >= 5L * arr[j])
                i--;

            count += n - 1 - i;
            j--;
        }

        return count;
    }
}