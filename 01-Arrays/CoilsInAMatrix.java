import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> formCoils(int n) {
        int matrixSize = 4 * n;
        ArrayList<Integer> coil1 = new ArrayList<>();
        ArrayList<Integer> coil2 = new ArrayList<>();

        int r1 = 0, c1 = 0;
        int r2 = matrixSize - 1, c2 = matrixSize - 1;

        coil1.add(r1 * matrixSize + c1 + 1);
        coil2.add(r2 * matrixSize + c2 + 1);

        int[] dr1 = {1, 0, -1, 0};
        int[] dc1 = {0, 1, 0, -1};

        int[] dr2 = {-1, 0, 1, 0};
        int[] dc2 = {0, -1, 0, 1};

        int dirIdx = 0;

        int steps = matrixSize - 1;
        for (int i = 0; i < steps; i++) {
            r1 += dr1[dirIdx];
            c1 += dc1[dirIdx];
            coil1.add(r1 * matrixSize + c1 + 1);

            r2 += dr2[dirIdx];
            c2 += dc2[dirIdx];
            coil2.add(r2 * matrixSize + c2 + 1);
        }

        for (int stepLen = matrixSize - 2; stepLen >= 2; stepLen -= 2) {
            for (int k = 0; k < 2; k++) {
                dirIdx = (dirIdx + 1) % 4;
                for (int i = 0; i < stepLen; i++) {
                    r1 += dr1[dirIdx];
                    c1 += dc1[dirIdx];
                    coil1.add(r1 * matrixSize + c1 + 1);

                    r2 += dr2[dirIdx];
                    c2 += dc2[dirIdx];
                    coil2.add(r2 * matrixSize + c2 + 1);
                }
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(coil1);
        result.add(coil2);
        return result;
    }
}
