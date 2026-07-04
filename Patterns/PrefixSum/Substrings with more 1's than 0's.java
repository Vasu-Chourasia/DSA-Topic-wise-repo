
class Solution {

    static class Fenwick {
        int[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 1];
        }

        void update(int idx) {
            while (idx <= n) {
                bit[idx]++;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public int countSubstring(String s) {
        int n = s.length();

        int[] prefix = new int[n + 1];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (s.charAt(i) == '1' ? 1 : -1);
            list.add(prefix[i + 1]);
        }

        Collections.sort(list);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int x : list) {
            if (!map.containsKey(x)) {
                map.put(x, rank++);
            }
        }

        Fenwick ft = new Fenwick(rank);

        long ans = 0;

        for (int x : prefix) {
            int idx = map.get(x);
            ans += ft.query(idx - 1);
            ft.update(idx);
        }

        return (int) ans;
    }
}