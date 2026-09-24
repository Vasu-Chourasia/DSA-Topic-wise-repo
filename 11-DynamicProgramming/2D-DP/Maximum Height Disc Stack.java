    import java.util.*;
    
    class Solution {
        public int maxStackHeight(int[] r, int[] h) {
            int n = r.length;
            int[][] discs = new int[n][2];
    
            for (int i = 0; i < n; i++) {
                discs[i][0] = r[i];
                discs[i][1] = h[i];
            }
    
            Arrays.sort(discs, (a, b) -> {
                if (a[0] != b[0])
                    return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            });
    
            int[] bit = new int[1002];
            int ans = 0, i = 0;
    
            while (i < n) {
                int j = i;
                while (j < n && discs[j][0] == discs[i][0])
                    j++;
    
                int[] dp = new int[j - i];
    
                for (int k = i; k < j; k++) {
                    int height = discs[k][1];
                    dp[k - i] = query(bit, height - 1) + height;
                    ans = Math.max(ans, dp[k - i]);
                }
    
                for (int k = i; k < j; k++)
                    update(bit, discs[k][1], dp[k - i]);
    
                i = j;
            }
    
            return ans;
        }
    
        private int query(int[] bit, int index) {
            int result = 0;
            while (index > 0) {
                result = Math.max(result, bit[index]);
                index -= index & -index;
            }
            return result;
        }
    
        private void update(int[] bit, int index, int value) {
            while (index < bit.length) {
                bit[index] = Math.max(bit[index], value);
                index += index & -index;
            }
        }
    }