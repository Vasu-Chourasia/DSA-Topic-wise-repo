
class Solution {
    public int minimumSum(String s) {
        int n=s.length();
        char[] arr= s.toCharArray();
        int sum=0;
        
        
        for(int i=0;i<s.length()/2;i++){
            int j= n-i-1;
            
            if (arr[i] != '?' && arr[j] != '?' && arr[i] != arr[j]) return -1;
            
            else if(arr[i]=='?' && arr[j]!='?'){
                arr[i]= arr[j];
            }
            
            else if(arr[i]!='?' && arr[j]=='?'){
                arr[j]= arr[i];
            }
        }
        int half= (n+1)/2;
        char firstKnown='a';
        for(int i=0;i<half;i++){
            if(arr[i]!='?'){
                firstKnown=arr[i];
                break;
            }
        }
        for( int i=0;i<half;i++){
            if(arr[i]=='?'){
                arr[i]= firstKnown;
            }
            else{
                break;
            }
        }
        for( int i=1; i<half;i++){
            if(arr[i]=='?'){
                arr[i]=arr[i-1];
            }
        }
        for( int i=0;i<n/2;i++){
            arr[n-i-1]=arr[i];
        }
        
        for( int i=1;i<n;i++){
            sum+= Math.abs(arr[i]-arr[i-1]);
        }
        return sum;
    }
}
