/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSubTree(Node root1, Node root2) {
        if(root1==null){
            return false;
        }
        if(root2==null){
            return true;
        }
        if(isSame(root1,root2)){
            return true;
            
        }
        return (isSubTree(root1.right,root2) || isSubTree(root1.left,root2));
    }
    
    public boolean isSame(Node root1, Node root2){
        if(root1==null && root2== null){
            return true;
        }
        if(root1==null || root2== null){
            return false;
        }
        if(root1.data!=root2.data){
            return false;
        }
        return (isSame(root1.right, root2.right) || isSame(root1.left,root2.left));
    }
}