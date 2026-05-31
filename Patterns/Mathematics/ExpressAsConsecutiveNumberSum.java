class Solution {
    public boolean isSumOfConsecutive(int n) {
        if(n <= 2)
        {
            return false;
        }
        while(n % 2 == 0)
        {
            n = n / 2;
        }
        if(n > 1)
        {
            return true;
        }
        return false;
    }
}