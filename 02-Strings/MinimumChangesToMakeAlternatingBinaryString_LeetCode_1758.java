class Solution {
    public int minOperations(String s) {
        int mismatch1 = 0; // pattern 0101...
        int mismatch2 = 0; // pattern 1010...

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(i % 2 == 0){
                if(c != '0') mismatch1++;
                if(c != '1') mismatch2++;
            } else {
                if(c != '1') mismatch1++;
                if(c != '0') mismatch2++;
            }
        }

        return Math.min(mismatch1, mismatch2);
    }
}