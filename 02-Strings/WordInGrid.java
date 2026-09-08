class Solution {
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (exists(mat, word, i, j)) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        ans.add(temp);
                    }
                }
            }
        }
        return ans;
    }

    private boolean exists(char[][] mat, String word, int x, int y) {
        int n = mat.length;
        int m = mat[0].length;

        // Try all 8 directions
        for (int d = 0; d < 8; d++) {
            int i = x;
            int j = y;
            int k;

            for (k = 0; k < word.length(); k++) {
                if (i < 0 || i >= n || j < 0 || j >= m)
                    break;

                if (mat[i][j] != word.charAt(k))
                    break;

                i += dx[d];
                j += dy[d];
            }

            if (k == word.length())
                return true;
        }

        return false;
    }
}