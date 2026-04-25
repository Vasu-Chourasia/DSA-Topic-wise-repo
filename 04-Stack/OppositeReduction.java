 import java.util.*;

class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int x : arr) {
            boolean destroyed = false;

            // Process collisions while opposite signs exist
            while (!stack.isEmpty() && isOpposite(stack.peek(), x)) {
                int top = stack.peek();

                if (Math.abs(top) > Math.abs(x)) {
                    // Top survives, current gets destroyed
                    destroyed = true;
                    break;
                } else if (Math.abs(top) < Math.abs(x)) {
                    // Current survives, remove top and continue checking
                    stack.pop();
                } else {
                    // Equal magnitude → both removed
                    stack.pop();
                    destroyed = true;
                    break;
                }
            }

            // If current element survives all collisions, push it
            if (!destroyed) {
                stack.push(x);
            }
        }

        return new ArrayList<>(stack);
    }

    // Helper function to check opposite signs
    private boolean isOpposite(int a, int b) {
        return (a > 0 && b < 0) || (a < 0 && b > 0);
    }
}