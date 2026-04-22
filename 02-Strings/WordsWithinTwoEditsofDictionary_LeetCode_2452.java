import java.util.*;

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        
        List<String> result = new ArrayList<>();
        
        // Traverse each query word
        for (String q : queries) {
            
            // Check against every dictionary word
            for (String d : dictionary) {
                
                int mismatch = 0;
                
                // Compare character by character
                for (int i = 0; i < q.length(); i++) {
                    if (q.charAt(i) != d.charAt(i)) {
                        mismatch++;
                    }
                    
                    // Optimization: stop early if > 2 mismatches
                    if (mismatch > 2) break;
                }
                
                // If valid match found
                if (mismatch <= 2) {
                    result.add(q);
                    break; // no need to check further dictionary words
                }
            }
        }
        
        return result;
    }
}