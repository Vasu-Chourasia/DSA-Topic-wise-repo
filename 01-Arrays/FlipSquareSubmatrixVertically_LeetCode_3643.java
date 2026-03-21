class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int i=x;
        int j=y;
        int pointer=x+k-1;
        while(i<x+k && i<pointer){
            while(j<y+k){
                int temp=grid[i][j];
                grid[i][j]=grid[pointer][j];
                grid[pointer][j]=temp;
                j++;
            }
            j=y;
            i++;
            pointer--;
        }
        return grid;
    }
}