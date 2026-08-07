class Solution {
    public long countFriendsPairings(int n) {
        if (n <= 2) {
            return n;
        }
        long prev2 = 1;
        long prev1 = 2;
        for (int i = 3; i <= n; i++) {
            long curr = prev1 + (long) (i - 1) * prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}