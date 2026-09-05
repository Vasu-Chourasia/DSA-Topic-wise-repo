import java.util.HashMap;

class Solution {
    public int longestSubseq(int[] arr) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 1;

        for (int x : arr) {
            int curr = Math.max(
                dp.getOrDefault(x - 1, 0),
                dp.getOrDefault(x + 1, 0)
            ) + 1;

            if (curr > dp.getOrDefault(x, 0)) {
                dp.put(x, curr);
            }

            ans = Math.max(ans, dp.get(x));
        }

        return ans;
    }
}