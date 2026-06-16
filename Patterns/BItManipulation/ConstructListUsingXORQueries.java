import java.util.*;

class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        ArrayList<Integer> list = new ArrayList<>();
        int currXor = 0;
        
        list.add(0);
        
        for(int i = 0; i < queries.length; i++)
        {
            if(queries[i][0] == 0)
            {
                list.add(queries[i][1] ^ currXor);
            }
            else
            {
                currXor ^= queries[i][1];
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < list.size(); i++)
        {
            result.add(list.get(i) ^ currXor);
        }
        
        Collections.sort(result);
        
        return result;
    }
}