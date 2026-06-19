class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        long[] prefix = new long[n];

        prefix[0] = arr[0];

        for (int i = 1; i < n; i++)
        {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < n; i++)
        {
            int mid = i / 2;

            long left = 0;
            if (mid > 0)
            {
                left = (long)arr[mid] * mid - prefix[mid - 1];
            }

            long right = (prefix[i] - prefix[mid]) - (long)arr[mid] * (i - mid);

            res.add((int)(left + right));
        }

        return res;
    }
}