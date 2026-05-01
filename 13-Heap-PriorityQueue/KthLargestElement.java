import java.util.*;

class Solution {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            if (minHeap.size() < k) {
                result.add(-1);
            } else {
                result.add(minHeap.peek());
            }
        }
        
        return result;
    }
}