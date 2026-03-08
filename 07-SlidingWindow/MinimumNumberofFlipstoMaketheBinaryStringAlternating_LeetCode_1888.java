class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String s2 = s + s;
        int diff1 = 0, diff2 = 0;
        int res = Integer.MAX_VALUE;
        int l = 0;
        for(int r = 0; r < 2*n; r++){
            char expected1 = (r % 2 == 0) ? '0' : '1';
            char expected2 = (r % 2 == 0) ? '1' : '0';
            if(s2.charAt(r) != expected1) diff1++;
            if(s2.charAt(r) != expected2) diff2++;
            if(r - l + 1 > n){
                char left1 = (l % 2 == 0) ? '0' : '1';
                char left2 = (l % 2 == 0) ? '1' : '0';
                if(s2.charAt(l) != left1) diff1--;
                if(s2.charAt(l) != left2) diff2--;
                l++;
            }
            if(r - l + 1 == n){
                res = Math.min(res, Math.min(diff1, diff2));
            }
        }

        return res;
    }
}