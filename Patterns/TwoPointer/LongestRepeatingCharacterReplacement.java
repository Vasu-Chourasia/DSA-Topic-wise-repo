class Solution{
    public int longestSubstr(String s,int k){
        int[] f=new int[26];
        int l=0,maxf=0,res=0;
        for(int r=0;r<s.length();r++){
            int idx=s.charAt(r)-'A';
            f[idx]++;
            maxf=Math.max(maxf,f[idx]);
            while((r-l+1)-maxf>k){
                f[s.charAt(l)-'A']--;
                l++;
            }
            res=Math.max(res,r-l+1);
        }
        return res;
    }
}