class Solution {
    private List<Integer> elements;
    private int pairs;

    public int pairsViolatingBST(Node root) {
        elements = new ArrayList<>();
        pairs = 0;

        reverseInorder(root);

        return pairs;
    }
    private void reverseInorder(Node root) {
        if (root == null) {
            return;
        }

        reverseInorder(root.right);

        int count = countSmaller(root.data);
        elements.add(count, root.data); 
        pairs += count;

        reverseInorder(root.left);
    }
    private int countSmaller(int target) {
        int l = 0;
        int r = elements.size() - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (elements.get(mid) >= target) {
                r = mid - 1;
            } else {
                ans = mid;
                l = mid + 1;
            }
        }

        return ans + 1;
    }
}