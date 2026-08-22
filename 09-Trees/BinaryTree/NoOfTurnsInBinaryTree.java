/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    static class Result {
         int turns = -1;
     }

     public int numberOfTurns(Node root, int p, int q) {

         Node lca = findLCA(root, p, q);
         if (lca.data == p) {
             Result res = new Result();
             if (findTurns(lca, q, 'N', 0, res))
                 return res.turns == 0 ? -1 : res.turns;
         }

         if (lca.data == q) {
             Result res = new Result();
             if (findTurns(lca, p, 'N', 0, res))
                 return res.turns == 0 ? -1 : res.turns;
         }

         Result left = new Result();
         Result right = new Result();

         findTurns(lca.left, p, 'L', 0, left);
         findTurns(lca.right, q, 'R', 0, right);

         if (left.turns == -1 || right.turns == -1) {
             left = new Result();
             right = new Result();
             findTurns(lca.left, q, 'L', 0, left);
             findTurns(lca.right, p, 'R', 0, right);
         }

         int ans = left.turns + right.turns + 1;
         return ans == 0 ? -1 : ans;
     }
     Node findLCA(Node root, int p, int q) {
         if (root == null)
             return null;

         if (root.data == p || root.data == q)
             return root;

         Node left = findLCA(root.left, p, q);
         Node right = findLCA(root.right, p, q);

         if (left != null && right != null)
             return root;

         return left != null ? left : right;
     }
     boolean findTurns(Node root, int target, char dir, int turns, Result res) {
         if (root == null)
             return false;

         if (root.data == target) {
             res.turns = turns;
             return true;
         }

         if (findTurns(root.left, target, 'L',
                 dir == 'R' ? turns + 1 : turns, res))
             return true;

         if (findTurns(root.right, target, 'R',
                 dir == 'L' ? turns + 1 : turns, res))
             return true;

         return false;
     }
}