import java.util.*;

class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;

        int[] partnerOfWoman = new int[n];
        Arrays.fill(partnerOfWoman, -1);

        int[] nextProposal = new int[n];

        int[] result = new int[n];

        int[][] rank = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rank[i][women[i][j]] = j;
            }
        }

        Queue<Integer> freeMen = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            freeMen.add(i);
        }

        while (!freeMen.isEmpty()) {
            int man = freeMen.poll();

            int woman = men[man][nextProposal[man]];
            nextProposal[man]++;

            if (partnerOfWoman[woman] == -1) {
                partnerOfWoman[woman] = man;
            } else {
                int currentMan = partnerOfWoman[woman];

                if (rank[woman][man] < rank[woman][currentMan]) {
                    partnerOfWoman[woman] = man;
                    freeMen.add(currentMan);
                } else {
                    freeMen.add(man);
                }
            }
        }

        for (int w = 0; w < n; w++) {
            int m = partnerOfWoman[w];
            result[m] = w;
        }

        return result;
    }
}