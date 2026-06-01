class Solution {
    public int findMaxProduct(int[] arr) {
        int mod=1000000007;
        long product=1;
        int negativeCount=0;
        int zeroCount=0;
        int maxNegative=Integer.MIN_VALUE;
        int nonZeroCount=0;

        for(int num:arr)
        {
            if(num==0)
            {
                zeroCount++;
                continue;
            }

            nonZeroCount++;

            if(num<0)
            {
                negativeCount++;
                maxNegative=Math.max(maxNegative,num);
            }

            product=(product*num)%mod;
        }

        if(nonZeroCount==0)
        {
            return 0;
        }

        if(negativeCount==1 && nonZeroCount==1 && zeroCount>0)
        {
            return 0;
        }

        if(nonZeroCount==1)
        {
            for(int num:arr)
            {
                if(num!=0)
                {
                    return num;
                }
            }
        }

        if(negativeCount%2!=0)
        {
            product=(product*modInverse(maxNegative,mod))%mod;
        }

        if(product<0)
        {
            product=(product+mod)%mod;
        }

        return (int)product;
    }

    private long modInverse(long a,int mod)
    {
        return power(a,mod-2,mod);
    }

    private long power(long base,int exp,int mod)
    {
        long result=1;
        base=(base%mod+mod)%mod;

        while(exp>0)
        {
            if((exp&1)==1)
            {
                result=(result*base)%mod;
            }

            base=(base*base)%mod;
            exp>>=1;
        }

        return result;
    }
}