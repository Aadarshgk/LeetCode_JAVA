class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return null;
        int sum=0;
        TreeNode temp1Left=null;
        TreeNode temp1Right=null;
        TreeNode temp2Left=null;
        TreeNode temp2Right=null;

        if(root1!=null){
            sum+=root1.val;
            temp1Left=root1.left;
            temp1Right=root1.right;
        }   

        if(root2!=null){
            sum+=root2.val;
            temp2Left=root2.left;
            temp2Right=root2.right;
        }
        TreeNode root=new TreeNode(sum);
        root.left=mergeTrees(temp1Left,temp2Left);
        root.right=mergeTrees(temp1Right,temp2Right);
        return root;
    }
}