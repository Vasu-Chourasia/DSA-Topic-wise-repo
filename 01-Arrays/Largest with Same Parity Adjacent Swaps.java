import java.util.*;

class Solution {
    public ArrayList<Integer> lexicographicallyLargest(int[] arr) {
        int n = arr.length, i = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (i < n) {
            int j = i;

            while (j + 1 < n && arr[j] % 2 == arr[j + 1] % 2)
                j++;

            Integer[] group = new Integer[j - i + 1];

            for (int k = i; k <= j; k++)
                group[k - i] = arr[k];

            Arrays.sort(group, Collections.reverseOrder());

            for (int num : group)
                result.add(num);

            i = j + 1;
        }

        return result;
    }
}