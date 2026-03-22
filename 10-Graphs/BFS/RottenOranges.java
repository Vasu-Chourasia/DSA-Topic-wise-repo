class Solution {
    // Check if a cell is inside grid boundaries
    static boolean isSafe(int i,int j,int n,int m){
        return (i>=0 && i<n && j>=0 && j<m);
    }

    static int orangesRot(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;

        // Queue for BFS (stores coordinates of rotten oranges)
        Queue<int[]> q=new LinkedList<>();

        int elapsedTime=0;

        // Step 1: Add all initially rotten oranges to queue
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }

        // Directions: down, right, up, left
        int[][] directions={{1,0},{0,1},{-1,0},{0,-1}};

        // Step 2: BFS traversal (level-wise = minute-wise)
        while(!q.isEmpty()){
            int size=q.size();
            boolean flag=false; // to check if any fresh orange rotted in this minute

            for(int i=0;i<size;i++){
                int[] cell=q.poll();
                int x=cell[0];
                int y=cell[1];

                // Check all 4 directions
                for(int[] dir:directions){
                    int nx=x+dir[0];
                    int ny=y+dir[1];

                    // If valid cell and fresh orange found
                    if(isSafe(nx,ny,n,m) && mat[nx][ny]==1){
                        mat[nx][ny]=2; // make it rotten
                        q.add(new int[]{nx,ny}); // push to queue
                        flag=true;
                    }
                }
            }

            // If at least one orange rotted, increment time
            if(flag) elapsedTime++;
        }

        // Step 3: Check if any fresh orange is left
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1) return -1; // impossible case
            }
        }

        return elapsedTime; // total time required
    }
}