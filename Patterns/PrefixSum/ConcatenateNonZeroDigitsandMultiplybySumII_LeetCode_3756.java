class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        final int MOD = 1_000_000_007;
        int n = s.length();
        int[] prefixNZ = new int[n + 1];

        for (int i = 0; i < n; i++)
        {
            prefixNZ[i + 1] = prefixNZ[i] + (s.charAt(i) != '0' ? 1 : 0);
        }

        int totalNZ = prefixNZ[n];
        long[] pow10 = new long[totalNZ + 1];
        pow10[0] = 1;

        for (int i = 1; i <= totalNZ; i++)
        {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        long[] hash = new long[totalNZ + 1];
        long[] digitSum = new long[totalNZ + 1];
        int idx = 0;

        for (int i = 0; i < n; i++)
        {
            char c = s.charAt(i);

            if (c != '0')
            {
                int d = c - '0';
                idx++;
                hash[idx] = (hash[idx - 1] * 10 + d) % MOD;
                digitSum[idx] = digitSum[idx - 1] + d;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++)
        {
            int l = queries[i][0];
            int r = queries[i][1];
            int left = prefixNZ[l];
            int right = prefixNZ[r + 1];

            if (left == right)
            {
                ans[i] = 0;
                continue;
            }

            int len = right - left;
            long value = (hash[right] - (hash[left] * pow10[len]) % MOD + MOD) % MOD;
            long sum = digitSum[right] - digitSum[left];
            ans[i] = (int)((value * (sum % MOD)) % MOD);
        }

        return ans;
    }
}