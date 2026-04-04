import java.util.*;

class Solution {
    public ArrayList<String> graycode(int n) {
        ArrayList<String> res = new ArrayList<>();

        // Base case
        res.add("0");
        res.add("1");

        // Build from 2 to n
        for (int i = 2; i <= n; i++) {
            int size = res.size();

            // Reverse and add '1' prefix
            for (int j = size - 1; j >= 0; j--) {
                res.add("1" + res.get(j));
            }

            // Add '0' prefix to first half
            for (int j = 0; j < size; j++) {
                res.set(j, "0" + res.get(j));
            }
        }

        return res;
    }
}