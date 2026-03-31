public class Solution {
    public String generateString(String str1,String str2){
        int n=str1.length(),m=str2.length();
        char[] word=new char[n+m-1];
        boolean[] fixed=new boolean[n+m-1];

        for(int i=0;i<word.length;i++) word[i]='?';

        for(int i=0;i<n;i++){
            if(str1.charAt(i)=='T'){
                for(int j=0;j<m;j++){
                    int idx=i+j;
                    if(word[idx]=='?'||word[idx]==str2.charAt(j)){
                        word[idx]=str2.charAt(j);
                        fixed[idx]=true;
                    }else return "";
                }
            }
        }

        for(int i=0;i<n;i++){
            if(str1.charAt(i)=='F'){
                boolean match=true,allFixed=true;
                for(int j=0;j<m;j++){
                    if(word[i+j]=='?'||word[i+j]!=str2.charAt(j)){
                        match=false;
                    }
                    if(!fixed[i+j]) allFixed=false;
                }
                if(match&&allFixed) return "";
            }
        }

        for(int i=0;i<word.length;i++){
            if(word[i]=='?') word[i]='a';
        }

        for(int i=0;i<n;i++){
            if(str1.charAt(i)=='F'){
                boolean match=true;
                for(int j=0;j<m;j++){
                    if(word[i+j]!=str2.charAt(j)){
                        match=false;
                        break;
                    }
                }

                if(match){
                    boolean changed=false;
                    for(int j=m-1;j>=0;j--){
                        int idx=i+j;
                        if(fixed[idx]) continue;

                        for(char c='a';c<='z';c++){
                            if(c!=word[idx]){
                                word[idx]=c;
                                changed=true;
                                break;
                            }
                        }
                        if(changed) break;
                    }
                    if(!changed) return "";
                }
            }
        }
        return new String(word);
    }
}