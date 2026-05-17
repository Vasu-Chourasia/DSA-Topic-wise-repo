class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        List<Integer> list= new ArrayList<>();
        for(int num:arr){
            if (!list.isEmpty() &&
                ((list.get(list.size() - 1) >= 0 && num < 0) ||
                 (list.get(list.size() - 1) < 0 && num >= 0))) {
                                list.remove(list.size() - 1);
                
            } else {
                list.add(num);
            }
        }
        return list;
    }
}