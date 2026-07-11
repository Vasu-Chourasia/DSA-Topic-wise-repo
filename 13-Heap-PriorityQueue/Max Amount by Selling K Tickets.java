class Solution {
    public int maxAmount(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : arr) {
            pq.offer(x);
        }
        long ans = 0;
        long MOD = 1_000_000_007L;
        while (k-- > 0 && !pq.isEmpty()) {
            int cur = pq.poll();
            ans = (ans + cur) % MOD;
            if (cur > 1) {
                pq.offer(cur - 1);
            }
        }
        return (int) ans;
    }
}