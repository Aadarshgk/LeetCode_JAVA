import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }

    public List<TreeNode> helper(int start, int end){
        List<TreeNode> list= new ArrayList<>();
        if(start>end){
            list.add(null);
            return list;
        }

        if(start==end){
            list.add(new TreeNode(start));
            return list;
        }  
        for(int i=start; i<=end;i++){
            List<TreeNode> leftTrees= helper(start, i-1);
            List<TreeNode> rightTrees= helper(i+1, end);

            for(TreeNode leftRoot: leftTrees){
                for(TreeNode rightRoot: rightTrees){
                    TreeNode root= new TreeNode(i);
                    root.left=leftRoot;
                    root.right= rightRoot;
                    list.add(root);
                }
            }
        }
        return list;
    }
}