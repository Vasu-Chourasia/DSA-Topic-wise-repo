
class Solution {
    public int countEdges(ArrayList<ArrayList<Integer>> adj) {
        int count = 0;

        for (ArrayList<Integer> list : adj) {
            count += list.size();
        }

        return count / 2;
    }
}
