class Solution {
    static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            Node node = curr.node;
            int hd = curr.hd;
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }
            if (node.left != null) {
                q.offer(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                q.offer(new Pair(node.right, hd + 1));
            }
        }

        for (int val : map.values()) {
            res.add(val);
        }

        return res;
    }
}