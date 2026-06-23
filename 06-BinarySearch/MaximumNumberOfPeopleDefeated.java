class Solution {
    int maxPeopleDefeated(int p) {
        int left = 0, right = 10000;
        int ans = 0;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            long sum = (long) mid * (mid + 1) * (2L * mid + 1) / 6;

            if (sum <= p)
            {
                ans = mid;
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return ans;
    }
}