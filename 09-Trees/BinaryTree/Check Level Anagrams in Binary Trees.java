class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.offer(root1);
        q2.offer(root2);
        while(!q1.isEmpty() && !q2.isEmpty()) {
            int size1 = q1.size();
            int size2 = q2.size();
            if (size1!= size2)
                return false;
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i=0;i<size1;i++) {
                Node node = q1.poll();
                map.put(node.data, map.getOrDefault(node.data, 0) + 1);
                if (node.left != null)
                    q1.offer(node.left);
                if (node.right != null)
                    q1.offer(node.right);
            }
            for (int i = 0; i < size2; i++) {
                Node node = q2.poll();
                if (!map.containsKey(node.data))
                    return false;
                map.put(node.data, map.get(node.data) - 1);
                if (map.get(node.data) == 0)
                    map.remove(node.data);
                if (node.left != null)
                    q2.offer(node.left);
                if (node.right != null)
                    q2.offer(node.right);
            }
            if (!map.isEmpty())
                return false;
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}