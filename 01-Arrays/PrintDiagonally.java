class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        int n = mat.length;
        ArrayList<Integer> res = new ArrayList<>();
        for (int sum = 0; sum <= 2 * (n - 1); sum++) {

            for (int i = 0; i < n; i++) {
                int j = sum - i;
                if (j >= 0 && j < n) {
                    res.add(mat[i][j]);
                }
            }
        }

        return res;
    }
}