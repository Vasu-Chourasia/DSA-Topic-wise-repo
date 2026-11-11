
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1, c2 = cost2, cb = costBoth;
        long n1 = need1, n2 = need2;

        long individual = n1 * c1 + n2 * c2;

        long commonMin = Math.min(n1, n2);
        long mixed = commonMin * cb
                   + (n1 - commonMin) * c1
                   + (n2 - commonMin) * c2;

        long commonMax = Math.max(n1, n2);
        long allBoth = commonMax * cb;

        return Math.min(individual, Math.min(mixed, allBoth));
    }
}
