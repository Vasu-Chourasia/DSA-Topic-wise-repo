class Solution {
    public int minProd(int[] arr) {
        int n = arr.length;
        int ans = Integer.MAX_VALUE;

        for (int mask = 1; mask < (1 << n); mask++) {
            int prod = 1;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    prod *= arr[i];
                }
            }
            ans = Math.min(ans, prod);
        }

        return ans;
    }
}