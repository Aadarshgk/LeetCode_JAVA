import java.util.List;
import java.util.ArrayList;
class Solution {
    List<Integer> res= new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return res;
    }

    public void postOrder(TreeNode root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        res.add(root.val);
    } 
}