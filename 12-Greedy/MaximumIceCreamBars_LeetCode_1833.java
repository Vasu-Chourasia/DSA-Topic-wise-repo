class Solution {
    public int maxIceCream(int[] costs, int coins) {

        int max = 0;
        for(int cost : costs)
        {
            if(cost > max)
            {
                max = cost;
            }
        }

        int[] count = new int[max + 1];

        for(int cost : costs)
        {
            count[cost]++;
        }

        int bars = 0;

        for(int i = 1; i <= max; i++)
        {
            if(count[i] == 0)
            {
                continue;
            }

            int canBuy = Math.min(count[i], coins / i);

            bars += canBuy;
            coins -= canBuy * i;

            if(coins < i)
            {
                break;
            }
        }

        return bars;
    }
}