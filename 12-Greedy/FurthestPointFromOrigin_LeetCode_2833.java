class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0, right = 0, blank = 0;
        
        // Count occurrences
        for (char ch : moves.toCharArray()) {
            if (ch == 'L') left++;
            else if (ch == 'R') right++;
            else blank++;
        }
        
        // Net position without blanks
        int pos = right - left;
        
        // Max distance = absolute position + all blanks used optimally
        return Math.abs(pos) + blank;
    }
}