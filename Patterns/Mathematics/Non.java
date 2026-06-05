class Solution {
    public int numOfWays(int n, int m) {
        long totalCells = (long) n * m;
        long totalWays = totalCells * (totalCells - 1);
        long attackingWays = 4L * ((long)(n - 1) * (m - 2) +
                                  (long)(n - 2) * (m - 1));

        return (int)(totalWays - attackingWays);
    }
}