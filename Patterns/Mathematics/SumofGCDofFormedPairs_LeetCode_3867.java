class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];

        int max = 0;

        for (int i = 0; i < n; i++)
        {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(nums[i], max);
        }

        java.util.Arrays.sort(prefixGcd);

        long ans = 0;

        for (int i = 0, j = n - 1; i < j; i++, j--)
            ans += gcd(prefixGcd[i], prefixGcd[j]);

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0)
        {
            int t = a % b;
            a = b;
            b = t;
        }

        return a;
    }
}