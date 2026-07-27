import java.util.*;

class Solution {
    private int preIndex;
    private HashMap<Integer, Integer> mirrorIndex;
    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        preIndex = 0;
        mirrorIndex = new HashMap<>();
        for (int i = 0; i < preMirror.length; i++) {
            mirrorIndex.put(preMirror[i], i);
        }
        return build(pre, preMirror, 0, preMirror.length - 1);
    }
    private Node build(int[] pre, int[] preMirror, int left, int right) {
        if (preIndex >= pre.length || left > right) {
            return null;
        }
        Node root = new Node(pre[preIndex++]);
        if (left == right || preIndex >= pre.length) {
            return root;
        }
        int index = mirrorIndex.get(pre[preIndex]);

        root.left = build(pre, preMirror, index, right);
        root.right = build(pre, preMirror, left + 1, index - 1);
        return root;
    }
}