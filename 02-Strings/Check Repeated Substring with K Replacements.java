import java.util.*;

class Solution
{
    public boolean kSubstr(String s, int k)
    {
        int n = s.length();

        if(n % k != 0)
        {
            return false;
        }

        int totalBlocks = n / k;
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i + k <= n; i += k)
        {
            String sub = s.substring(i, i + k);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }

        int maxFreq = 0;

        for(int freq : map.values())
        {
            if(freq > maxFreq)
            {
                maxFreq = freq;
            }
        }

        if(maxFreq >= totalBlocks - 1)
        {
            return true;
        }

        return false;
    }
}