import java.util.*;

class Solution {
    static int timer;

    static void dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,
                    boolean[] vis,int[] tin,int[] low,boolean[] mark){

        vis[node]=true;
        tin[node]=low[node]=timer++;
        int child=0;

        for(int it:adj.get(node)){
            if(it==parent)continue;

            if(!vis[it]){
                dfs(it,node,adj,vis,tin,low,mark);

                low[node]=Math.min(low[node],low[it]);

                if(low[it]>=tin[node] && parent!=-1){
                    mark[node]=true;
                }
                child++;
            }else{
                low[node]=Math.min(low[node],tin[it]);
            }
        }

        if(parent==-1 && child>1)mark[node]=true;
    }

    static ArrayList<Integer> articulationPoints(int V,int[][] edges){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());

        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] vis=new boolean[V];
        int[] tin=new int[V];
        int[] low=new int[V];
        boolean[] mark=new boolean[V];
        timer=0;

        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,-1,adj,vis,tin,low,mark);
            }
        }

        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(mark[i])res.add(i);
        }

        if(res.size()==0){
            res.add(-1);
        }

        return res;
    }
}