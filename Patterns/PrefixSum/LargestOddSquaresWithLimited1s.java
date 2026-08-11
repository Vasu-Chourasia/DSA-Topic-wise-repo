class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] prefix = new int[n + 1][m + 1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                prefix[i + 1][j + 1] = mat[i][j] + prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j];
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for(int[] query : queries) {
            int i = query[0];
            int j = query[1];

            int maxRadius = Math.min(Math.min(i, n - 1 - i), Math.min(j, m - 1 - j));

            if(getSum(prefix, i, j, i, j) > k) {
                ans.add(-1);
                continue;
            }

            int low = 0;
            int high = maxRadius;
            int best = 0;

            while(low <= high) {
                int mid = low + (high - low) / 2;
                int top = i - mid;
                int bottom = i + mid;
                int left = j - mid;
                int right = j + mid;

                int ones = getSum(prefix, top, left, bottom, right);

                if(ones <= k) {
                    best = mid;
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }

            ans.add(2 * best + 1);
        }

        return ans;
    }

    private int getSum(int[][] prefix, int r1, int c1, int r2, int c2) {
        return prefix[r2 + 1][c2 + 1] - prefix[r1][c2 + 1] - prefix[r2 + 1][c1] + prefix[r1][c1];
    }
}