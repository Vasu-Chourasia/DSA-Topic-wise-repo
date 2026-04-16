class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // Step 1: Map each value to list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        // Step 2: Process each query
        for (int q : queries) {
            int value = nums[q];
            List<Integer> list = map.get(value);

            // If only one occurrence → answer = -1
            if (list.size() == 1) {
                result.add(-1);
                continue;
            }

            // Step 3: Binary search to find position of q in list
            int pos = Collections.binarySearch(list, q);

            int minDist = Integer.MAX_VALUE;

            // Check previous index in list (circular)
            int prevIndex = (pos - 1 + list.size()) % list.size();
            int prev = list.get(prevIndex);

            int dist1 = Math.abs(q - prev);
            dist1 = Math.min(dist1, n - dist1); // circular

            // Check next index in list (circular)
            int nextIndex = (pos + 1) % list.size();
            int next = list.get(nextIndex);

            int dist2 = Math.abs(q - next);
            dist2 = Math.min(dist2, n - dist2); // circular

            minDist = Math.min(dist1, dist2);

            result.add(minDist);
        }

        return result;
    }
}