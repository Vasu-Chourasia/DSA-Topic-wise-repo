class Solution{
    public int smallestSubstring(String s){
        int n=s.length(),l=0,ans=Integer.MAX_VALUE;
        int[] f=new int[3];
        for(int r=0;r<n;r++){
            f[s.charAt(r)-'0']++;
            while(f[0]>0&&f[1]>0&&f[2]>0){
                ans=Math.min(ans,r-l+1);
                f[s.charAt(l)-'0']--;
                l++;
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}