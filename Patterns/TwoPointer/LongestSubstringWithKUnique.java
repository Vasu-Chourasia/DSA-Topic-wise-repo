import java.util.*;

class Solution {
    public int longestKSubstr(String s, int k) {
        HashMap<Character,Integer> h=new HashMap<>();
        int l=0,r=0,res=-1;

        while(r<s.length()){
            char ch=s.charAt(r);
            h.put(ch,h.getOrDefault(ch,0)+1);

            while(h.size()>k){
                char leftChar=s.charAt(l);
                h.put(leftChar,h.get(leftChar)-1);
                if(h.get(leftChar)==0) h.remove(leftChar);
                l++;
            }

            if(h.size()==k)
                res=Math.max(res,r-l+1);

            r++;
        }

        return res;
    }
}