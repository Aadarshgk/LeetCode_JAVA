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
        if(root.left==null && root.right==null && root.val==targetSum) {
            res.add(new ArrayList<>(list));
        }else{
            pathSum(root.left,targetSum-root.val,list);
            pathSum(root.right,targetSum-root.val,list);
        } 
        list.remove(list.size()-1);
        
    }
}