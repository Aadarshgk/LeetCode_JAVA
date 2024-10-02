class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right){
        if(left==right) return true;
        if(left==null || right==null) return false;
        return left.val==right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}