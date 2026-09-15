public int maxPalindromes(String s, int k) {
        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];

            for (int len = k; len <= k + 1; len++) {
                int left = i - len;
                int right = i - 1;

                if (left < 0) continue;

                boolean isPalindrome = true;

                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        isPalindrome = false;
                        break;
                    }
                    left++;
                    right--;
                }

                if (isPalindrome) {
                    dp[i] = Math.max(dp[i], dp[i - len] + 1);
                }
            }
        }

        return dp[n];
    }