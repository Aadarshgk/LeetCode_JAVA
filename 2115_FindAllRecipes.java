import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String,List<String>> adj=new HashMap<>();
        HashMap<String,Integer> indegree=new HashMap<>();

        HashSet<String> supply=new HashSet<>();
        for(String s: supplies){
            supply.add(s);
        }

        for(int i=0;i<recipes.length;i++){
            indegree.put(recipes[i],0);
            for(String ing: ingredients.get(i)){
                if(!supply.contains(ing)){
                    if(!adj.containsKey(ing)){
                        adj.put(ing,new ArrayList<>());
                    }
                    adj.get(ing).add(recipes[i]);
                    indegree.put(recipes[i],indegree.getOrDefault(recipes[i],0)+1);
                }
            }
        }

        Queue<String> q=new LinkedList<>();
        for(Map.Entry<String,Integer>entry: indegree.entrySet()){
            if(entry.getValue()==0){
                q.offer(entry.getKey());
            }
        }

        List<String> res=new ArrayList<>();
        while(!q.isEmpty()){
            String cur=q.poll();
            res.add(cur);

            if(adj.containsKey(cur)){
                for(String nextRec:adj.get(cur)){
                    indegree.put(nextRec,indegree.get(nextRec)-1);
                    if(indegree.get(nextRec)==0){
                        q.offer(nextRec);
                    }
                }
            }
        }
        return res;
    }
}