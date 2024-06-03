class Solution {
    public int maxDepth(TreeNode root) {
        if(root!=null){
            if(root.left==null && root.right==null){
                return 1;
            }
            int left=0,right=0;
            if(root.left!=null){
                left=1+maxDepth(root.left);
            }
            if(root.right!=null){
                right=1+maxDepth(root.right);
            }
            return Math.max(left,right);
        }
        return 0;
    }
}