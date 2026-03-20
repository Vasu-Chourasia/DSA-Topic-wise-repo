class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[][] res = new int[n-k+1][m-k+1];
        for (int i = 0; i <= n-k; i++) {
            List<Integer> elements = new ArrayList<>();
            for (int j = 0; j <= m-k; j++) {
                if (j == 0) {
                    elements.clear();
                    for (int r = i; r < i+k; r++)
                        for (int c = 0; c < k; c++)
                            elements.add(grid[r][c]);
                } else {
                    for (int r = i; r < i+k; r++)
                        elements.remove(Integer.valueOf(grid[r][j-1]));
                    for (int r = i; r < i+k; r++)
                        elements.add(grid[r][j+k-1]);
                }
                List<Integer> temp = new ArrayList<>(new TreeSet<>(elements));
                if (temp.size() <= 1) { res[i][j] = 0; continue; }
                int diff = Integer.MAX_VALUE;
                for (int x = 0; x < temp.size()-1; x++)
                    diff = Math.min(diff, temp.get(x+1) - temp.get(x));
                res[i][j] = diff;
            }
        }
        return res;
    }
}