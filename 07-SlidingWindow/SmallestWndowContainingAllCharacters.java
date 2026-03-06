class Solution {
    public static String minWindow(String s, String p) {
        int[] freqP=new int[26];
        int[] freqS=new int[26];
        for(char c:p.toCharArray())
            freqP[c-'a']++;
        int start=0,minLen=Integer.MAX_VALUE,count=0,l=0;
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            freqS[ch-'a']++;
            if(freqS[ch-'a']<=freqP[ch-'a'])
                count++;
            while(count==p.length()){
                if(r-l+1<minLen){
                    minLen=r-l+1;
                    start=l;
                }
                char left=s.charAt(l);
                freqS[left-'a']--;
                if(freqS[left-'a']<freqP[left-'a'])
                    count--;
                l++;
            }
        }
        if(minLen==Integer.MAX_VALUE) return "";
        return s.substring(start,start+minLen);
    }
}