import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n = mat.length;
        int[][] path = new int[n][n];
        boolean[][] failed = new boolean[n][n];

        if (solve(mat, 0, 0, path, failed, n))
        {
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            for (int i = 0; i < n; i++)
            {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++)
                {
                    row.add(path[i][j]);
                }
                res.add(row);
            }
            return res;
        }

        ArrayList<ArrayList<Integer>> fail = new ArrayList<>();
        fail.add(new ArrayList<>(Arrays.asList(-1)));
        return fail;
    }

    private boolean solve(int[][] mat, int i, int j, int[][] path, boolean[][] failed, int n) {
        if (i >= n || j >= n || mat[i][j] == 0 || failed[i][j])
        {
            return false;
        }

        path[i][j] = 1;

        if (i == n - 1 && j == n - 1)
        {
            return true;
        }

        int maxJump = mat[i][j];

        for (int step = 1; step <= maxJump; step++)
        {
            if (solve(mat, i, j + step, path, failed, n))
            {
                return true;
            }

            if (solve(mat, i + step, j, path, failed, n))
            {
                return true;
            }
        }

        path[i][j] = 0;
        failed[i][j] = true;
        return false;
    }
}