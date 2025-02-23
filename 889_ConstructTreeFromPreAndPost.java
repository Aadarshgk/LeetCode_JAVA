class Solution {
    int pre=0,post=0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root= new TreeNode(preorder[pre]);
        pre++;

        if(root.val!=postorder[post]){
            root.left=constructFromPrePost(preorder,postorder);
        }
        if(root.val!=postorder[post]){
            root.right=constructFromPrePost(preorder,postorder);
        }

        post++;
        return root;
    }
}