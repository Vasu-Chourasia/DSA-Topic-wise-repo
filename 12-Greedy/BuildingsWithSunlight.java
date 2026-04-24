class Solution {
    public int visibleBuildings(int arr[]) {
        int maxHeight = 0; // tracks tallest building so far
        int count = 0;     // number of buildings getting sunlight
        
        for (int height : arr) {
            // If current building is not blocked
            if (height >= maxHeight) {
                count++;              // it gets sunlight
                maxHeight = height;   // update max height
            }
        }
        
        return count;
    }
}