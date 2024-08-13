import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combination(candidates, 0, new ArrayList<>(), target);
        return res;
    }

    public void combination(int[] candidates, int i,List<Integer> list, int target){
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        
        if(i==candidates.length || target-candidates[i]<0){
            return;
        }

        
        list.add(candidates[i]);
        combination(candidates,i+1,list,target-candidates[i]);
        list.remove(list.size()-1);

        while(i<candidates.length-1 && candidates[i]==candidates[i+1]){
            i++;
        }

        combination(candidates,i+1,list,target);

    }
}