class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048;

        boolean[] present = new boolean[MAX];

        for (int num : nums) {
            present[num] = true;
        }

        boolean[] pairXor = new boolean[MAX];

        for (int a = 0; a < MAX; a++) {
            if (!present[a]) continue;

            for (int b = 0; b < MAX; b++) {
                if (!present[b]) continue;

                pairXor[a ^ b] = true;
            }
        }

        boolean[] tripletXor = new boolean[MAX];

        for (int a = 0; a < MAX; a++) {
            if (!present[a]) continue;

            for (int x = 0; x < MAX; x++) {
                if (pairXor[x]) {
                    tripletXor[a ^ x] = true;
                }
            }
        }

        int count = 0;
        for (boolean possible : tripletXor) {
            if (possible) {
                count++;
            }
        }

        return count;
    }
}