class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        // Traverse all indices
        for (int i = 0; i < n; i++) {
            // Check if current word matches target
            if (words[i].equals(target)) {
                found = true;

                // Distance moving right (clockwise)
                int right = (i - startIndex + n) % n;

                // Distance moving left (anticlockwise)
                int left = (startIndex - i + n) % n;

                // Take minimum of both directions
                int currMin = Math.min(right, left);

                // Update global minimum
                minDistance = Math.min(minDistance, currMin);
            }
        }

        // If target not found, return -1
        return found ? minDistance : -1;
    }
}