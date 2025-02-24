import java.util.List;
import java.util.ArrayList;
class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int len=edges.length+1;
        List<List<Integer>> adj=  new ArrayList<>();
        for(int i=0;i<len;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> bobPath=new ArrayList<>();
        List<Integer> curPath=new ArrayList<>();
        
        findBobPath(adj,curPath,bobPath,bob,-1);
        int size=bobPath.size(),i=0;
        for(i=0;i<size/2;i++){
            amount[bobPath.get(i)]=0;
        }

        if(size%2==1){
            amount[bobPath.get(i)]=0;
        }else{
            amount[bobPath.get(i)]/=2;
        }

        return maxAmount(adj,0,-1,amount);
    }

    public boolean findBobPath(List<List<Integer>> adj,List<Integer> curPath,List<Integer> bobPath,int bob,int parent){
        if(bob==0){
            bobPath.clear();
            bobPath.addAll(curPath);
            return true;
        }

        curPath.add(bob);
        for(int nbr: adj.get(bob)){
            if(nbr!=parent && findBobPath(adj,curPath,bobPath,nbr,bob)){
                return true;
            }
        }
        curPath.remove(curPath.size()-1);
        return false;

    }

    public int maxAmount(List<List<Integer>> adj,int cur, int par,int[] amount){
        int maxAmt=Integer.MIN_VALUE;
        for(int nbr: adj.get(cur)){
            if(nbr!=par){
                int inc=maxAmount(adj,nbr,cur,amount);
                if(inc+amount[cur]> maxAmt){
                    maxAmt=inc + amount[cur];
                }
            }
        }
        return maxAmt==Integer.MIN_VALUE? amount[cur]:maxAmt;
    }
}