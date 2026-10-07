/* Node Structure
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    int ans = Integer.MIN_VALUE;
    int solve(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        if (root.left == null && root.right == null) return root.data;
        if (root.left == null)
            return root.data + solve(root.right);
        if (root.right == null)
            return root.data + solve(root.left);
        int left = solve(root.left);
        int right = solve(root.right);
        ans = Math.max(ans, left + root.data + right);
        return root.data + Math.max(left, right);
    }
    public int maxPathSum(Node root) {
        if (root == null) return -1;
        solve(root);
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}