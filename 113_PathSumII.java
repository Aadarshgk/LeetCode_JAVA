import java.util.List;
import java.util.ArrayList;
class Solution {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return res;
        pathSum(root, targetSum, new ArrayList<>());
        return res;
    }

    public void pathSum(TreeNode root, int targetSum, List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        targetSum-=root.val;
        if(root.left==null && root.right==null) {
            if(targetSum==0){
                res.add(new ArrayList<>(list));
            }
            return;
        }else{
            pathSum(root.left,targetSum,new ArrayList<>(list));
            pathSum(root.right,targetSum,new ArrayList<>(list));
        } 
        
    }
}