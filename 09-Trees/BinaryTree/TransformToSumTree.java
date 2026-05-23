class Solution {

    public void toSumTree(Node root) {
        convert(root);
    }
    private int convert(Node root) {
        if (root == null) return 0;
        int leftSum = convert(root.left);
        int rightSum = convert(root.right);
        int originalValue = root.data;
        root.data = leftSum + rightSum;

        return root.data + originalValue;
    }
}