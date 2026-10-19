class Solution {
    public int goodIndices(int[] arr) {
        int n = arr.length;
        int[] state = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (state[i] != 0) {
                if (state[i] == 2) count++;
                continue;
            }

            int curr = i;
            java.util.ArrayList<Integer> path = new java.util.ArrayList<>();

            while (curr >= 0 && curr < n && state[curr] == 0) {
                state[curr] = 1;
                path.add(curr);
                curr += arr[curr];
            }

            boolean good = curr < 0 || curr >= n || state[curr] == 2;

            for (int j = path.size() - 1; j >= 0; j--) {
                state[path.get(j)] = good ? 2 : 3;
            }

            if (state[i] == 2) count++;
        }

        return count;
    }
}