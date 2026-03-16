/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int countAllPaths(Node root, int k) {
        HashMap<Long, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0L, 1);
        return dfs(root, 0L, k, prefixMap);
    }

    private int dfs(Node node, long currSum, int k, HashMap<Long, Integer> prefixMap) {
        if (node == null) return 0;
        currSum += node.data;
        int count = prefixMap.getOrDefault(currSum - k, 0);
        prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) + 1);
        count += dfs(node.left, currSum, k, prefixMap);
        count += dfs(node.right, currSum, k, prefixMap);
        prefixMap.put(currSum, prefixMap.get(currSum) - 1);
        if (prefixMap.get(currSum) == 0) prefixMap.remove(currSum);
        return count;
    }
}