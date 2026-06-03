import java.util.*;

class Solution 
{
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) 
    {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++)
        {
            if(!map.containsKey(arr[i]))
            {
                map.put(arr[i], new ArrayList<>());
            }

            map.get(arr[i]).add(i);
        }

        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 0; i < queries.length; i++)
        {
            int l = queries[i][0];
            int r = queries[i][1];
            int x = queries[i][2];

            if(!map.containsKey(x))
            {
                res.add(0);
            }
            else
            {
                ArrayList<Integer> list = map.get(x);

                int left = lowerBound(list, l);
                int right = upperBound(list, r);

                res.add(right - left);
            }
        }

        return res;
    }

    private int lowerBound(ArrayList<Integer> list, int target)
    {
        int left = 0;
        int right = list.size();

        while(left < right)
        {
            int mid = (left + right) / 2;

            if(list.get(mid) >= target)
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }

        return left;
    }

    private int upperBound(ArrayList<Integer> list, int target)
    {
        int left = 0;
        int right = list.size();

        while(left < right)
        {
            int mid = (left + right) / 2;

            if(list.get(mid) > target)
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }

        return left;
    }
}