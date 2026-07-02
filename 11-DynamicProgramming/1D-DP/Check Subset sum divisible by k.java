class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        boolean[] dp = new boolean[k];

        for (int num : arr) {
            boolean[] next = dp.clone();

            next[num % k] = true;

            for (int r = 0; r < k; r++) {
                if (dp[r])
                    next[(r + num) % k] = true;
            }

            dp = next;

            if (dp[0])a
                return true;
        }

        return false;
    }
}