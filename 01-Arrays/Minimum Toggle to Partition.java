class Solution {
    public int minToggle(int[] arr) {
        int n = arr.length;
        int[] prefixOnes = new int[n + 1];
        int[] suffixZeros = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixOnes[i + 1] = prefixOnes[i] + (arr[i] == 1 ? 1 : 0);
        }

        for (int i = n - 1; i >= 0; i--) {
            suffixZeros[i] = suffixZeros[i + 1] + (arr[i] == 0 ? 1 : 0);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            ans = Math.min(ans, prefixOnes[i] + suffixZeros[i]);
        }

        return ans;
    }
}