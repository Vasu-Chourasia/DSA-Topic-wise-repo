class Solution {
    String URLify(String s) {
        // StringBuilder for efficient concatenation
        StringBuilder result = new StringBuilder();
        
        // Traverse the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Replace space with %20
            if (ch == ' ') {
                result.append("%20");
            } else {
                result.append(ch);
            }
        }
        
        // Return final string
        return result.toString();
    }
}