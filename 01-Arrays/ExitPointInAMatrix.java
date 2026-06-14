class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int i = 0, j = 0;
        int dir = 0;

        while (i >= 0 && i < n && j >= 0 && j < m) {
            if (mat[i][j] == 1) {
                dir = (dir + 1) % 4;
                mat[i][j] = 0;
            }

            if (dir == 0) j++;
            else if (dir == 1) i++;
            else if (dir == 2) j--;
            else i--;
        }

        if (dir == 0) j--;
        else if (dir == 1) i--;
        else if (dir == 2) j++;
        else i++;

        return Arrays.asList(i, j);
    }
}