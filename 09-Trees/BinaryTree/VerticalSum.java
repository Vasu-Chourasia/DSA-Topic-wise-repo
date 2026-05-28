/* Structure of binary tree node
class Node{
public:
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution { 
    HashMap<Integer,Integer> mp= new HashMap<>();
    
    void calVerticalSum(Node root, int level){
        
        if (root == null) return;

        mp.put(level,mp.getOrDefault(level,0)+root.data);
        calVerticalSum(root.left, level-1);
        calVerticalSum(root.right, level+1);
        
    }
    
    public ArrayList<Integer> verticalSum(Node root) {
        ArrayList<Integer> arr= new ArrayList<>();
        calVerticalSum(root,0);
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(mp);

        for(Map.Entry<Integer, Integer> num: sortedMap.entrySet()){
            arr.add(num.getValue());
        }
        return arr;
        
    }
}