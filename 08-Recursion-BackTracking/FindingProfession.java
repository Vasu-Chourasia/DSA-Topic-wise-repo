class Solution {
    public String profession(int level, int pos) {
        int count = Integer.bitCount(pos-1);
        if (count % 2 == 0){
            return "Engineer";
        }
        else{
            return "Doctor";
        }
    }
}