class Solution {
    public long sumXOR(int[] arr) {
        int n = arr.length;
        long totalSum=0;
        for (int i=0;i<32;i++) {
            long cnt1=0;
            for (int num:arr) {
                if ((num&(1<<i))!=0){
                    cnt1++;
                }
            }

            long cnt0=n-cnt1;
            long sum=cnt1*cnt0*(1L<<i);
            totalSum+=sum;
        }
        return totalSum;
    }
}