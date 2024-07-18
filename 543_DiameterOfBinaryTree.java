class Solution {
    int result=0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return result;
    }

    public int depth(TreeNode root){
        if(root==null) return 0;
        int left=depth(root.left);
        int right=depth(root.right);
        result=Math.max(result,left+right);
        return 1+Math.max(left,right);
    }
}