class Solution {
    public int sameMod(int[] arr) {
            int gcd = 0;
            for (int i = 1; i < arr.length; i++) {
                gcd = gcd(gcd, Math.abs(arr[i] - arr[0]));
            }
            if (gcd == 0) return -1;
            int count = 0;
            for (int d = 1; d * d <= gcd; d++) {
                if (gcd % d == 0) {
                    count++;
                    if (d != gcd / d) count++;
                }
            }
            return count;
        }

        private int gcd(int a, int b) {
            while (b != 0) {
                int temp = a % b;
                a = b;
                b = temp;
            }
            return a;
        }
}