/* Structure of Binary Tree Node
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
}*/
class Solution {
    private int maxLength = 1;

    public int longestConsecutive(Node root) {
        if (root == null) {
            return -1;
        }

        dfs(root, root.data - 1, 0);

        return maxLength == 1 ? -1 : maxLength;
    }

    private void dfs(Node current, int previousValue, int currentLength) {
        if (current == null) {
            return;
        }

        if (current.data == previousValue + 1) {
            currentLength++;
        } else {
            currentLength = 1;
        }

        maxLength = Math.max(maxLength, currentLength);

        dfs(current.left, current.data, currentLength);
        dfs(current.right, current.data, currentLength);
    }
}