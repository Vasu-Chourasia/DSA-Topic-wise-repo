
class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        long odd = 0;
        long even = 1;
        long prefixSum = 0;
        long count = 0;
        for (int num : arr) {
            prefixSum += num;

            if (prefixSum % 2 == 1) {
                count = (count + even) % MOD;
                odd++;
            } else {
                count = (count + odd) % MOD;
                even++;
            }
        }
        return (int) count;
    }
}
