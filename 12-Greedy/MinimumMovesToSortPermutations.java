class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;
        int[] pos = new int[n + 1];

        for (int i = 0; i < n; i++) {
            pos[arr[i]] = i;
        }

        int longest = 1;
        int curr = 1;

        for (int i = 2; i <= n; i++) {
            if (pos[i - 1] < pos[i]) {
                curr++;
            } else {
                curr = 1;
            }
            longest = Math.max(longest, curr);
        }

        return n - longest;
    }
}