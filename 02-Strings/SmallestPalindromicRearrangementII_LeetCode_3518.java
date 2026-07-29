class Solution {
    private static final int LIMIT = 1_000_000;
    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int[] half = new int[26];
        char mid = 0;
        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            if ((freq[i] & 1) == 1) {
                mid = (char) ('a' + i);
            }
        }
        if (countWays(half) < k) {
            return "";
        }
        int halfLen = s.length() / 2;
        StringBuilder left = new StringBuilder();
        for (int pos = 0; pos < halfLen; pos++) {
            for (int ch = 0; ch < 26; ch++) {
                if (half[ch] == 0) {
                    continue;
                }
                half[ch]--;
                int ways = countWays(half);
                if (ways >= k) {
                    left.append((char) ('a' + ch));
                    break;
                }
                k -= ways;
                half[ch]++;
            }
        }
        StringBuilder ans = new StringBuilder();
        ans.append(left);
        if (mid != 0) {
            ans.append(mid);
        }
        ans.append(new StringBuilder(left).reverse());
        return ans.toString();
    }
    private int countWays(int[] cnt) {
        long ways = 1;
        int used = 0;
        for (int value : cnt) {
            if (value == 0) {
                continue;
            }
            ways *= combination(used + value, value);
            if (ways > LIMIT) {
                return LIMIT + 1;
            }
            used += value;
        }
        return (int) ways;
    }
    private int combination(int n, int r) {
        r = Math.min(r, n - r);
        long result = 1;
        for (int i = 1; i <= r; i++) {
            long numerator = n - r + i;
            long denominator = i;
            long gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
            gcd = gcd(result, denominator);
            result /= gcd;
            denominator /= gcd;
            result *= numerator;
            result /= denominator;
            if (result > LIMIT) {
                return LIMIT + 1;
            }
        }
        return (int) result;
    }
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}