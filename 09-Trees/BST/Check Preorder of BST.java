class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        Stack<Integer> ancestors = new Stack<>();
        int lowerBound = Integer.MIN_VALUE;

        for (int value : arr) {
            if (value < lowerBound) {
                return false;
            }

            while (!ancestors.isEmpty() && value > ancestors.peek()) {
                lowerBound = ancestors.pop();
            }

            ancestors.push(value);
        }

        return true;
    }
}
