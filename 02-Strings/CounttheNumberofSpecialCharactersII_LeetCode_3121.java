class Solution{
    public int numberOfSpecialChars(String word){
        int[] l=new int[26],u=new int[26];

        for(int i=0;i<26;i++)
            l[i]=-1;

        for(int i=0;i<26;i++)
            u[i]=Integer.MAX_VALUE;

        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c>='a'&&c<='z')
                l[c-'a']=i;
            else if(u[c-'A']==Integer.MAX_VALUE)
                u[c-'A']=i;
        }

        int cnt=0;

        for(int i=0;i<26;i++)
            if(l[i]!=-1&&u[i]!=Integer.MAX_VALUE&&l[i]<u[i])
                cnt++;

        return cnt;
    }
}