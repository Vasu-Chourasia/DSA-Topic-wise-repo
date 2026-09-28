class Solution {
    int[] tree;
    public ArrayList<Integer> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, 0, n - 1);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 0) {
                ans.add(queryGCD(0, 0, n - 1, query[1], query[2]));
            } else {
                arr[query[1]] = query[2];
                update(0, 0, n - 1, query[1], query[2]);
            }
        }
        return ans;
    }
    void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        build(arr, 2 * node + 1, start, mid);
        build(arr, 2 * node + 2, mid + 1, end);
        tree[node] = gcd(tree[2 * node + 1], tree[2 * node + 2]);
    }
    int queryGCD(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return tree[node];
        int mid = start + (end - start) / 2;
        return gcd(
            queryGCD(2 * node + 1, start, mid, l, r),
            queryGCD(2 * node + 2, mid + 1, end, l, r)
        );
    }
    void update(int node, int start, int end, int index, int value) {
        if (start == end) {
            tree[node] = value;
            return;
        }
        int mid = start + (end - start) / 2;
        if (index <= mid)
            update(2 * node + 1, start, mid, index, value);
        else
            update(2 * node + 2, mid + 1, end, index, value);
        tree[node] = gcd(tree[2 * node + 1], tree[2 * node + 2]);
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}