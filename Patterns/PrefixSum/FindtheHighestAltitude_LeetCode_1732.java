class Solution {
    public int largestAltitude(int[] gain) {
        int curr = 0;
        int maxAlt = 0;

        for (int i = 0; i < gain.length; i++)
        {
            curr += gain[i];

            if (curr > maxAlt)
            {
                maxAlt = curr;
            }
        }

        return maxAlt;
    }
}