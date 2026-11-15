
class Solution {
    public int subsequenceSum(String s) {
        long MOD = 1000000007;
        int n = s.length();

        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += s.charAt(i) - '0';
        }

        long power = 1;

        for (int i = 0; i < n - 1; i++) {
            power = (power * 2) % MOD;
        }

        long ans = (sum * power) % MOD;

        return (int) ans;
    }
}
