class Solution {
    int result=0,count=0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return result;
    }

    public void inorder(TreeNode root,int k){
        if(root!=null){
            inorder(root.left,k);
            if(++count==k){
                result=root.val;
                return;
            }
            inorder(root.right,k);
        }
    }
}