class Solution {
    int max=0;
    public int longestZigZag(TreeNode root) {
        helper(root.left,0,true);
        helper(root.right,0,false);
        return max;
    }

    public void helper(TreeNode root,int len,boolean flag){
        if(root==null){
            max=Math.max(max,len);
            return;
        }

        if(flag){
            helper(root.left,0,true);
            helper(root.right,len+1,false);
        }else{
            helper(root.right,0,false);
            helper(root.left,len+1,true);
        }
    }
}