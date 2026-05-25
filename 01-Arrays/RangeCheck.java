import java.util.*;

class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        if((end-start+1)>arr.length) 
            return false;
        Set<Integer> set = new HashSet<>();
        for(int num: arr) {
            set.add(num);
        }
        for (int i =start;i<=end; i++) {
            if(!set.contains(i)) return false;
        }
        return true;
    }
}