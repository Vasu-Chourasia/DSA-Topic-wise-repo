class Solution {
    public int maxSumSubarray(int[] arr) {
        int noDelete = arr[0];
        int oneDelete = -1000000000;   // Negative infinity
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int prevNoDelete = noDelete;

            noDelete = Math.max(arr[i], noDelete + arr[i]);
            oneDelete = Math.max(oneDelete + arr[i], prevNoDelete);

            ans = Math.max(ans, Math.max(noDelete, oneDelete));
        }

        return ans;
    }
}