import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> path= new ArrayList<>();
        path.add(0);
        check(graph,0,path,res);
        return res;
    }

    public void check(int[][] graph,int i,List<Integer> path, List<List<Integer>> res){
        if(i+1 == graph.length){
            res.add(new ArrayList<>(path));
            return;
        }
        if(graph[i].length==0){
            return;
        }

        for(int a: graph[i]){
            path.add(a);
            check(graph,a,path,res);
            path.remove(path.size()-1);
        }
    }
}