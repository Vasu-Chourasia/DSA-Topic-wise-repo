class Solution {
    public int maxDiffSum(int[] arr) {
        int n=arr.length;
        if (n==1) return 0;
        int keep=0;
        int rep=0;
        for (int i=1;i<n;i++) {
            int newKeep = Math.max(
                keep+Math.abs(arr[i]-arr[i-1]),
                rep+Math.abs(arr[i]-1)
            );
            int newRep = Math.max(
                keep + Math.abs(1 - arr[i - 1]),
                rep
            );
            keep = newKeep;
            rep = newRep;
        }
        return Math.max(keep, rep);
    }
}