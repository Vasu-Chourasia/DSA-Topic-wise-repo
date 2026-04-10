import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        // Map to store indices of each number
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Step 1: Store indices
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int minDistance = Integer.MAX_VALUE;

        // Step 2: Process each number
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);

            // Need at least 3 occurrences
            if (list.size() < 3) continue;

            // Step 3: Check consecutive triplets
            for (int i = 0; i <= list.size() - 3; i++) {
                int left = list.get(i);
                int right = list.get(i + 2);

                // distance = 2 * (k - i)
                int dist = 2 * (right - left);

                minDistance = Math.min(minDistance, dist);
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}