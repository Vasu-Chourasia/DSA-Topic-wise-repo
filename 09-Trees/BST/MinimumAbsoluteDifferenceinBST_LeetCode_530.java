/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int absDiff(Node root) {
        int[] prev = {-1};
        int[] min = {Integer.MAX_VALUE};
        inorder(root, prev, min);
        return min[0];
    }
    private void inorder(Node root, int[] prev, int[] min) {
        if (root == null) return;
        inorder(root.left, prev, min);
        if (prev[0] != -1)
            min[0] = Math.min(min[0], root.data - prev[0]);
        prev[0] = root.data;
        inorder(root.right, prev, min);
    }
}
