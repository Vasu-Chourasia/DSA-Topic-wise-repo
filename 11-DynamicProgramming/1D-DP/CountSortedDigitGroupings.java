import java.util.*;

class Solution
{
    int[][] dp;
    int[] prefix;
    int n;

    public int validGroups(String s)
    {
        n=s.length();
        prefix=new int[n+1];

        for(int i=0;i<n;i++)
        {
            prefix[i+1]=prefix[i]+(s.charAt(i)-'0');
        }

        dp=new int[n][901];

        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }

        return solve(0,0,s);
    }

    private int solve(int index,int prevSum,String s)
    {
        if(index==n)
        {
            return 1;
        }

        if(dp[index][prevSum]!=-1)
        {
            return dp[index][prevSum];
        }

        int count=0;

        for(int i=index;i<n;i++)
        {
            int currentSum=prefix[i+1]-prefix[index];

            if(currentSum>=prevSum)
            {
                count+=solve(i+1,currentSum,s);
            }
        }

        return dp[index][prevSum]=count;
    }
}