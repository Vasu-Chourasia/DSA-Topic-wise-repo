import java.util.*;

class Solution {

    ArrayList<Integer> sortBySetBitCount(int[] arr) {

        // Step 1: Convert int[] → Integer[] for sorting
        Integer[] temp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        // Step 2: Stable sort based on set bits (descending)
        Arrays.sort(temp, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);

            return countB - countA; // descending
        });

        // Step 3: Convert to ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : temp) {
            result.add(num);
        }

        return result;
    }
}