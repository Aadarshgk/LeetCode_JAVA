class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;

        TreeNode tempLeft=root.left;
        TreeNode tempRight=root.right;

        root.left=null;
        flatten(tempLeft);
        flatten(tempRight);

        root.right=tempLeft;
        TreeNode curr=root;
        while(curr!=null && curr.right!=null){
            curr=curr.right;
        }
        curr.right=tempRight;
    }
}