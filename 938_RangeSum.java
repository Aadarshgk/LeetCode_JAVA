class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        int left=0, right=0;
        if(root.val>=low){
            left= rangeSumBST(root.left,low,high);
        }
        if(root.val<=high){
            right= rangeSumBST(root.right,low,high);
        }
        if(root.val>=low && root.val<=high) return root.val+left+right;
        return left+right;   
    }
}