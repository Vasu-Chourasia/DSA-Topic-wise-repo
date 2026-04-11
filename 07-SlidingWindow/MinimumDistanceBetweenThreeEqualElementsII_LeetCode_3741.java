import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        // Step 1: Map value -> list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int minDistance = Integer.MAX_VALUE;
        
        // Step 2: Process each value group
        for (List<Integer> indices : map.values()) {
            
            // Need at least 3 indices
            if (indices.size() < 3) continue;
            
            // Step 3: Check consecutive triplets
            for (int i = 0; i <= indices.size() - 3; i++) {
                int first = indices.get(i);
                int third = indices.get(i + 2);
                
                int distance = 2 * (third - first);
                minDistance = Math.min(minDistance, distance);
            }
        }
        
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}