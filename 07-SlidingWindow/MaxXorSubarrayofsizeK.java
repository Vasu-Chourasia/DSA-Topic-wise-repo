
class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int l=0;
        int r=0;
        int currXor=0;
        while(r<=k-1){
            currXor^=arr[r];
            r++;
        }
        int maxXor=currXor;

        for(;r<arr.length;r++){
            currXor=currXor^arr[l];
            l++;
            currXor=currXor^arr[r];
            maxXor= Math.max(maxXor,currXor);

        }
        return maxXor;
    }
}

