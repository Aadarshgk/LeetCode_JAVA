class Solution {
    int count=0;
    public int goodNodes(TreeNode root) {
        helper(root,Integer.MIN_VALUE);
        return count;   
    }

    public void helper(TreeNode root,int max){
        if(root==null) return;

        if(root.val>=max){
            max=root.val;
            count++;
        }
        helper(root.left,max);
        helper(root.right,max);
    }
}