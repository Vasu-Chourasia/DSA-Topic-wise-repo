
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFactor = 1500;
        int maxPrice = 1500;

        int[] cnt = new int[maxFactor + 1];

        for (int[] item : items) {
            cnt[item[0]]++;
        }

        int[] weight = new int[maxFactor + 1];

        for (int f = 1; f <= maxFactor; f++) {
            for (int j = f; j <= maxFactor; j += f) {
                weight[f] += cnt[j];
            }
        }

        int[][] groups = new int[maxPrice + 1][];

        int[] groupSize = new int[maxPrice + 1];

        for (int[] item : items) {
            groupSize[item[1]]++;
        }

        for (int p = 1; p <= maxPrice; p++) {
            groups[p] = new int[groupSize[p]];
        }

        int[] index = new int[maxPrice + 1];

        for (int[] item : items) {
            int p = item[1];
            groups[p][index[p]++] = weight[item[0]];
        }

        int NEG = -1_000_000_000;

        int[] higher = new int[budget + 1];
        int[] exact = new int[budget + 1];

        java.util.Arrays.fill(higher, NEG);
        higher[0] = 0;

        int ans = 0;

        for (int p = maxPrice; p >= 1; p--) {

            if (groupSize[p] == 0) {
                continue;
            }

            java.util.Arrays.fill(exact, NEG);

            for (int w : groups[p]) {
                for (int c = budget; c >= p; c--) {
                    if (exact[c - p] != NEG) {
                        exact[c] = Math.max(
                            exact[c],
                            exact[c - p] + w
                        );
                    }

                    if (higher[c - p] != NEG) {
                        exact[c] = Math.max(
                            exact[c],
                            higher[c - p] + w
                        );
                    }
                }
            }

            for (int c = 0; c <= budget; c++) {
                if (exact[c] != NEG) {
                    ans = Math.max(
                        ans,
                        exact[c] + (budget - c) / p
                    );
                }
            }

            for (int w : groups[p]) {
                for (int c = budget; c >= p; c--) {
                    if (higher[c - p] != NEG) {
                        higher[c] = Math.max(
                            higher[c],
                            higher[c - p] + w
                        );
                    }
                }
            }
        }

        return ans;
    }
}
