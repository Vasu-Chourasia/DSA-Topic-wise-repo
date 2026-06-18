class Solution {
    public int findCoverage(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int totalCoverage = 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(mat[i][j] == 0)
                {
                    int coverage = 0;

                    for(int col = j - 1; col >= 0; col--)
                    {
                        if(mat[i][col] == 1)
                        {
                            coverage++;
                            break;
                        }
                    }

                    for(int col = j + 1; col < m; col++)
                    {
                        if(mat[i][col] == 1)
                        {
                            coverage++;
                            break;
                        }
                    }

                    for(int row = i - 1; row >= 0; row--)
                    {
                        if(mat[row][j] == 1)
                        {
                            coverage++;
                            break;
                        }
                    }

                    for(int row = i + 1; row < n; row++)
                    {
                        if(mat[row][j] == 1)
                        {
                            coverage++;
                            break;
                        }
                    }

                    totalCoverage += coverage;
                }
            }
        }

        return totalCoverage;
    }
}