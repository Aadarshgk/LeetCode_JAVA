import java.util.Arrays;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] invocation : invocations) {
            adj.get(invocation[0]).add(invocation[1]);
        }

        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);

        dfs(adj,vis,k);

        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!vis[i]){
                for(int a: adj.get(i)){
                    if(vis[a]){
                        for(int j=0;j<n;j++){
                            res.add(j);
                        }
                        return res;
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            if(!vis[i]){
                res.add(i);
            }
        }
        return res;

    }

    public void dfs(List<List<Integer>> adj,boolean[] vis,int k){
        vis[k]=true;
        Stack<Integer> stack=new Stack<>();
        stack.push(k);
        while(!stack.isEmpty()){
            int  top=stack.pop();
            for(int n: adj.get(top)){
                if(!vis[n]){
                    stack.push(n);
                    vis[n]=true;
                }
            }
        }
    }
}