/*
Category
Greedy
Name of the Problem
Minimum Swaps to Make Binary Grid Valid

Concept

Greedy Strategy

Matrix Traversal

Counting Trailing Zeros

Bubble-like Row Swapping

Approach to Solve the Problem

We are given an n x n binary grid. We can swap only adjacent rows. The grid is valid if all cells above the main diagonal contain 0.

For a cell (i, j), if j > i, then it lies above the main diagonal. Therefore, for row i, all elements from column i+1 to n-1 must be zero.

Key observation:

For each row, count how many trailing zeros it has (zeros from the right end).
If a row has k trailing zeros, it can satisfy any position i such that:

k ≥ (n - 1 - i)

This is because row i needs at least (n - 1 - i) zeros at the end to ensure all cells above the diagonal are zero.

Greedy Strategy:

For each row, compute trailing zero count.

For position i from 0 to n-1:

Find the first row j ≥ i such that trailingZeros[j] ≥ (n - 1 - i).

If no such row exists, return -1.

Bring row j up to position i using adjacent swaps.

Number of swaps required = j - i.

Accumulate total swaps.

This works because:

We always try to place the nearest valid row to minimize swaps.

Since only adjacent swaps are allowed, this behaves like a bubble-up process.

Time Complexity: O(n²)
Space Complexity: O(n)
*/





import java.util.*;

public class MinimumSwapsBinaryGrid {
    public static int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailingZeros = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) count++;
                else break;
            }
            trailingZeros[i] = count;
        }
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int requiredZeros = n - 1 - i;
            int j = i;
            while (j < n && trailingZeros[j] < requiredZeros) {
                j++;
            }
            if (j == n) return -1;
            while (j > i) {
                int temp = trailingZeros[j];
                trailingZeros[j] = trailingZeros[j - 1];
                trailingZeros[j - 1] = temp;
                j--;
                swaps++;
            }
        }
        return swaps;
    }
    public static void main(String[] args) {
        int[][] grid = {
            {0,0,1},
            {1,1,0},
            {1,0,0}
        };

        System.out.println("Minimum Swaps: " + minSwaps(grid));
    }
}