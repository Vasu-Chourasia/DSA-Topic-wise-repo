import java.util.*;

class Solution {
    public int sumDiffPairs(int[] arr,int k) {
        Arrays.sort(arr);
        int n=arr.length;
        int sum=0;

        for(int i=n-1;i>0;)
        {
            if(arr[i]-arr[i-1]<k)
            {
                sum+=arr[i]+arr[i-1];
                i-=2;
            }
            else
            {
                i--;
            }
        }

        return sum;
    }
}