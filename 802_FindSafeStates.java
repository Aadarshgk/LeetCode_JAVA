import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int len=graph.length;
        int[] vis = new int[len];   
        boolean[] safe = new boolean[len];
        Arrays.fill(vis,0);
        Arrays.fill(safe,true);

        for(int i=0;i<len;i++){
            if(vis[i]==0){
                checkEnd(graph,vis,safe,i);
            }
        }

        List<Integer> res= new ArrayList<>();
        for(int i=0;i<len;i++){
            if(safe[i]){
                res.add(i);
            }
        }

        return res;


    }

    public boolean checkEnd(int[][] graph, int[] vis,boolean[] safe,int num){
        vis[num]=1;
        boolean res=true;

        for(int n: graph[num]){
            if(vis[n]==0){
                res= (res && checkEnd(graph,vis,safe,n));
            }else if(vis[n]==1){
                safe[num]=false;
                return false;
            }else if(vis[n]==2){
                res= (res && safe[n]);
            }
        }

        vis[num]=2;
        safe[num]=res;
        return res;
    }
}