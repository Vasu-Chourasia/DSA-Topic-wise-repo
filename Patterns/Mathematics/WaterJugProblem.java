class Solution {

    // Function to calculate GCD using Euclidean Algorithm
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Function to simulate pouring from one jug to another
    private int pour(int fromCap, int toCap, int d) {
        int from = fromCap; // fill source jug
        int to = 0;         // destination jug initially empty

        int step = 1; // first step: filling source jug

        while (from != d && to != d) {
            // Transfer water from source to destination
            int transfer = Math.min(from, toCap - to);
            to += transfer;
            from -= transfer;

            step++;

            // Check if we got desired amount
            if (from == d || to == d)
                break;

            // If source becomes empty, fill it again
            if (from == 0) {
                from = fromCap;
                step++;
            }

            // If destination becomes full, empty it
            if (to == toCap) {
                to = 0;
                step++;
            }
        }

        return step;
    }

    public int minSteps(int m, int n, int d) {

        // If d is more than both jugs → impossible
        if (d > Math.max(m, n))
            return -1;

        // Check feasibility using GCD
        if (d % gcd(m, n) != 0)
            return -1;

        // Compute both ways and return minimum
        return Math.min(pour(m, n, d), pour(n, m, d));
    }
}