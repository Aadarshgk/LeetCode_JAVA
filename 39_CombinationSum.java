import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();
        combinations(candidates,0,0,target, new ArrayList<>(),res);
        return res;
    }

    public void combinations(int[] candidates, int i,int sum, int target, List<Integer> comb, List<List<Integer>> res){
        if(sum>target) return;

        if(sum==target){
            res.add(new ArrayList<>(comb));
            return;
        }

        for(int j=i;j<candidates.length;j++){
            comb.add(candidates[j]);
            combinations(candidates,j,sum+candidates[j],target, comb,res);
            comb.remove(comb.size()-1);
        }
    }
}