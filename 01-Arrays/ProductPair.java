import java.util.*;

class Solution {
    public boolean isProduct(int[] arr, long target) {
        Set<Long> set = new HashSet<>();
        if (target == 0) {
            int zeroCount = 0;
            for (int x : arr) {
                if (x == 0) zeroCount++;
                else if (zeroCount > 0) return true;
            }
            return zeroCount > 1; 
        }
        for (int x : arr) {
            if (x != 0 && target % x == 0) {
                long needed = target / x;
                
                if (set.contains(needed)) {
                    return true;
                }
            }
            set.add((long)x);
        }
        
        return false;
    }
}