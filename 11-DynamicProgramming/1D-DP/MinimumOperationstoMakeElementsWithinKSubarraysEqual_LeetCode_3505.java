
import java.util.*;

class Solution {
    class SlidingMedian {
        TreeMap<Integer, Integer> lower = new TreeMap<>();
        TreeMap<Integer, Integer> upper = new TreeMap<>();
        int lowerSize = 0, upperSize = 0;
        long lowerSum = 0, upperSum = 0;

        void addToMap(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        void removeFromMap(TreeMap<Integer, Integer> map, int val) {
            int count = map.get(val);
            if (count == 1) map.remove(val);
            else map.put(val, count - 1);
        }

        void add(int val) {
            if (lower.isEmpty() || val <= lower.lastKey()) {
                addToMap(lower, val);
                lowerSize++;
                lowerSum += val;
            } else {
                addToMap(upper, val);
                upperSize++;
                upperSum += val;
            }
            balance();
        }

        void remove(int val) {
            if (lower.containsKey(val)) {
                removeFromMap(lower, val);
                lowerSize--;
                lowerSum -= val;
            } else {
                removeFromMap(upper, val);
                upperSize--;
                upperSum -= val;
            }
            balance();
        }

        void balance() {
            while (lowerSize > upperSize + 1) {
                int val = lower.lastKey();
                removeFromMap(lower, val);
                lowerSize--;
                lowerSum -= val;
                addToMap(upper, val);
                upperSize++;
                upperSum += val;
            }
            while (lowerSize < upperSize) {
                int val = upper.firstKey();
                removeFromMap(upper, val);
                upperSize--;
                upperSum -= val;
                addToMap(lower, val);
                lowerSize++;
                lowerSum += val;
            }
        }

        long getCost() {
            int median = lower.lastKey();
            return (long) median * lowerSize - lowerSum
                    + upperSum - (long) median * upperSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];
        SlidingMedian sm = new SlidingMedian();

        for (int i = 0; i < x; i++) sm.add(nums[i]);
        cost[0] = sm.getCost();

        for (int i = x; i < n; i++) {
            sm.remove(nums[i - x]);
            sm.add(nums[i]);
            cost[i - x + 1] = sm.getCost();
        }

        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];

                if (i >= x && dp[i - x][j - 1] != INF) {
                    long take = dp[i - x][j - 1] + cost[i - x];
                    dp[i][j] = Math.min(dp[i][j], take);
                }
            }
        }

        return dp[n][k];
    }
}
