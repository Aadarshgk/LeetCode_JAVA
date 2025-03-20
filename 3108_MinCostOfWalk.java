import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] dis= new int[n];
        Arrays.fill(dis,-1);
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0],edge[2]});

            int px=find(dis,edge[0]);
            int py=find(dis,edge[1]);
            if(px!=py){
                dis[px]=py;
            }
        }

        HashMap<Integer,Integer> map=new HashMap<>();
        boolean[] vis=new boolean[n];
        Arrays.fill(vis,false);
        for(int i=0;i<n;i++){
            if(!vis[i]){
                int[] bitAnd=new int[1];
                if(adj.get(i).size()==0){
                    bitAnd[0]=0;
                }else{
                    bitAnd[0]=adj.get(i).get(0)[1];
                }
                helper(bitAnd,i,vis,adj);
                int parent=find(dis,i);
                map.put(parent,bitAnd[0]);
            }
        }

        int[] res=new int[query.length];
        int i=0;
        for(int[] q: query){
            int px=find(dis,q[0]);
            int py=find(dis,q[1]);
            if(px==py){ res[i]=map.get(px);}
            else {res[i]=-1;}
            i++;
        }
        return res;
    }

    public void helper(int[] bitAnd,int cur,boolean[] vis,List<List<int[]>> adj){
        vis[cur]=true;
        for(int[] temp: adj.get(cur)){
            bitAnd[0]&=temp[1];
            if(!vis[temp[0]]){
                helper(bitAnd,temp[0],vis,adj);
            }
        }
    }

    public int find(int[] dis,int v){
        if(dis[v]==-1){
            return v;
        }
        dis[v]=find(dis,dis[v]);
        return dis[v];
    }
}