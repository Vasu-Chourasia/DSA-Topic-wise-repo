// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    static int maxSize = 0;
    static int largestBst(Node root) {
        maxSize = 0;
        solve(root);
        return maxSize;
    }

    static Info solve(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info left = solve(root.left);
        Info right = solve(root.right);
        if (left.isBST && right.isBST &&
            root.data > left.max && root.data < right.min) {
            int currSize = left.size + right.size + 1;
            maxSize = Math.max(maxSize, currSize);
            int currMin = Math.min(root.data, left.min);
            int currMax = Math.max(root.data, right.max);

            return new Info(true, currSize, currMin, currMax);
        }
        return new Info(false, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}