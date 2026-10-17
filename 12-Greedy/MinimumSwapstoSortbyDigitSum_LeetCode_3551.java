
import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        Integer[] sorted = new Integer[n];

        for (int i = 0; i < n; i++) sorted[i] = nums[i];

        Arrays.sort(sorted, (a, b) -> {
            int x = digitSum(a), y = digitSum(b);
            return x != y ? Integer.compare(x, y) : Integer.compare(a, b);
        });

        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) pos.put(sorted[i], i);

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || pos.get(nums[i]) == i) continue;

            int j = i, cycle = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = pos.get(nums[j]);
                cycle++;
            }

            swaps += cycle - 1;
        }

        return swaps;
    }

    private int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
