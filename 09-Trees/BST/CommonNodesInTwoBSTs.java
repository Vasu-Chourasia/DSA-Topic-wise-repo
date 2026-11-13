/* Structure of a Binary Search Tree node
class Node {
  public int data;
  public Node left;
  public Node right;

  public Node(int val) {
      data = val;
      left = right = null;
  }
};
*/


import java.util.*;

class Solution {
    class BSTIterator {
        Stack<Node> st = new Stack<>();

        BSTIterator(Node root) {
            pushLeft(root);
        }

        void pushLeft(Node node) {
            while (node != null) {
                st.push(node);
                node = node.left;
            }
        }

        Node next() {
            Node node = st.pop();
            pushLeft(node.right);
            return node;
        }

        boolean hasNext() {
            return !st.isEmpty();
        }
    }

    public ArrayList<Integer> findCommon(Node r1, Node r2) {
        ArrayList<Integer> ans = new ArrayList<>();

        BSTIterator it1 = new BSTIterator(r1);
        BSTIterator it2 = new BSTIterator(r2);

        while (it1.hasNext() && it2.hasNext()) {
            int a = it1.st.peek().data;
            int b = it2.st.peek().data;

            if (a == b) {
                ans.add(a);
                it1.next();
                it2.next();
            } else if (a < b) {
                it1.next();
            } else {
                it2.next();
            }
        }

        return ans;
    }
}
