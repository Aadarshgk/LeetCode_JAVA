/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        boolean left=false,right=true;
        if(root1.left!=null){
            if(root2.left!=null && root2.left.val==root1.left.val){
                left=flipEquiv(root1.left,root2.left);
            }else{
                left=flipEquiv(root1.left,root2.right);
            }
        } 

        if(root1.right!=null){
            if(root2.left!=null && root2.left.val==root1.right.val){
                left=flipEquiv(root1.right,root2.left);
            }else{
                left=flipEquiv(root1.right,root2.right);
            }
        } 

        return left && right;
    }
}