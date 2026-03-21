

class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        
        // Using concept of catalan in calculation of possible BST with number of nodes n
        // Catalan[n]= 2n!/{(n+1)!*n!}
        
        // No of possible BST with arr[i] as a root== Catalan[Number of nodes in left]* Catalan[Number of nodes in right]                           
        int n = arr.length;

        // Step 1: Sort a copy of array
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        // Step 2: Precompute Catalan numbers up to n
        int[] catalan = new int[n + 1];
        catalan[0] = 1;
        catalan[1] = 1;

        // DP for Catalan
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        // Step 3: Process each element
        for (int i = 0; i < n; i++) {
            int val = arr[i];

            // Find index in sorted array
            int index = 0;
            while (sorted[index] != val) {
                index++;
            }

            int left = index;
            int right = n - index - 1;

            int count = catalan[left] * catalan[right];
            res.add(count);
        }

        return res;
        
    }
}