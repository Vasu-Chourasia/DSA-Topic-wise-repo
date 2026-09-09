class Solution {
    private int digitSum(long x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public int findMax(int n) {
        long best = n;
        int maxSum = digitSum(n);

        long pow = 1;

        while (pow <= n) {
            long cur = (n / (pow * 10)) * (pow * 10);
            long digit = (n / pow) % 10;

            if (digit > 0) {
                long candidate = cur + (digit - 1) * pow + (pow - 1);

                int sum = digitSum(candidate);

                if (sum > maxSum || (sum == maxSum && candidate > best)) {
                    maxSum = sum;
                    best = candidate;
                }
            }

            pow *= 10;
        }

        return (int) best;
    }
}