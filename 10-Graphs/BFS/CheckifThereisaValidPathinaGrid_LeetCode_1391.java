import java.util.*;
class Solution{
    public boolean hasValidPath(int[][] grid){
        int m=grid.length,n=grid[0].length;
        int[][][] dirs={
            {},
            {{0,-1},{0,1}},
            {{-1,0},{1,0}},
            {{0,-1},{1,0}},
            {{0,1},{1,0}},
            {{0,-1},{-1,0}},
            {{0,1},{-1,0}}
        };
        boolean[][] vis=new boolean[m][n];
        
        Queue<int[]> q=new LinkedList<>();

        q.offer(new int[]{0,0});

        vis[0][0]=true;

        while(!q.isEmpty()){
            int[] cur=q.poll();
            int r=cur[0],c=cur[1];

            if(r==m-1&&c==n-1)return true;

            int type=grid[r][c];

            for(int[] d:dirs[type]){
                int nr=r+d[0],nc=c+d[1];

                if(nr<0||nc<0||nr>=m||nc>=n||vis[nr][nc])continue;

                int nt=grid[nr][nc];
                for(int[] b:dirs[nt]){
                    if(nr+b[0]==r&&nc+b[1]==c){
                        vis[nr][nc]=true;
                        q.offer(new int[]{nr,nc});
                        break;
                    }
                }
            }
        }
        return false;
    }
}