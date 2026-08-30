class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;
        long[] prefix = new long[n];
        for (int i = 0; i < n; i++) {
            long len = (long) r[i] - l[i] + 1;
            prefix[i] = len + (i > 0 ? prefix[i - 1] : 0);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int rk : rank) {
            int idx = lowerBound(prefix, rk);
            long prev = (idx == 0) ? 0 : prefix[idx - 1];
            int mark = (int) (l[idx] + (rk - prev - 1));
            ans.add(mark);
        }
        return ans;
    }
    private int lowerBound(long[] prefix, long target) {
        int low = 0, high = prefix.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (prefix[mid] >= target)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}