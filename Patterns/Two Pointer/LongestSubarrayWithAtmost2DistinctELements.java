class Solution {
    public int totalElements(int[] arr) {
        HashMap<Integer,Integer> mp= new HashMap<>();
        int res=0;
        int l=0;
        for(int r=0;r<arr.length;r++){
            mp.put(arr[r],mp.getOrDefault(arr[r],0)+1);
            
            while(mp.size()>2){
                mp.put(arr[l],mp.get(arr[l])-1);
                if(mp.get(arr[l])==0){
                    mp.remove(arr[l]);
                }
                l++;
            }
            res= Math.max(res,r-l+1);
        }
        return res;
    }
}