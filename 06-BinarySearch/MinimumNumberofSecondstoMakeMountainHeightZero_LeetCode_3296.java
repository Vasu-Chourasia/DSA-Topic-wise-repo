class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left=1;
        long right=(long)1e18;
        long ans=right;
        while(left<=right){
            long mid=left+(right-left)/2;
            if(canReduce(mid,mountainHeight,workerTimes)){
                ans=mid;
                right=mid-1;
            }else{
                left= mid+1;
            }
        }
        return ans;
    }
    public boolean canReduce(long time,int mountainHeight, int[] workerTimes){
        long totalHeightReduced=0;
        for(int w:workerTimes){
            long left=0;
            long right=mountainHeight;
            while(left<=right){
                long mid= left+(right-left)/2;
                long required=(long) w*mid*(mid+1)/2;
                if(required<=time){
                    left = mid+1;

                }else{
                    right= mid-1;

                }
            }
            totalHeightReduced+=right;
            if(totalHeightReduced>=mountainHeight) return true;
        }
        return false;

    }
}