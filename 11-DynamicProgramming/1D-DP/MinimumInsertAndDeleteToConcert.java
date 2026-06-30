import java.util.*;

class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Store index of each element in b
        for (int i = 0; i < b.length; i++) {
            map.put(b[i], i);
        }

        ArrayList<Integer> lis = new ArrayList<>();

        for (int num : a) {
            if (!map.containsKey(num))
                continue;

            int idx = map.get(num);

            int pos = Collections.binarySearch(lis, idx);

            if (pos < 0)
                pos = -(pos + 1);

            if (pos == lis.size())
                lis.add(idx);
            else
                lis.set(pos, idx);
        }

        int lcs = lis.size();

        return (a.length - lcs) + (b.length - lcs);
    }
}