
class Solution {
    public int cntSubsets(int arr[], int l, int r) {
        final long MOD = 1000000007L;
        int n = arr.length;

        long[] freq = new long[n + 2];
        for (int x : arr) {
            if (x <= n) freq[x]++;
        }

        long[] pow2 = new long[n + 1];
        pow2[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow2[i] = pow2[i - 1] * 2 % MOD;
        }

        long[] suffix = new long[n + 2];
        for (int i = n; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + freq[i];
        }

        long answer = 0;
        long required = 1;
        boolean possible = true;

        for (int k = 0; k <= r; k++) {
            if (k > 0) {
                if (freq[k - 1] == 0) {
                    possible = false;
                } else {
                    required = required *
                        ((pow2[(int) freq[k - 1]] - 1 + MOD) % MOD) % MOD;
                }
            }

            if (k >= l && possible) {
                long unrestricted = pow2[(int) suffix[k + 1]];
                answer = (answer + required * unrestricted) % MOD;
            }
        }

        return (int) answer;
    }
}