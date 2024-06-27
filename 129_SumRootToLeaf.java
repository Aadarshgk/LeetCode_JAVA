class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root,0);
    }

    public int sumNumbers(TreeNode root,int sum){
        if(root==null) return 0;

        sum= sum*10 + root.val;
        if(root.left==null && root.right==null) return sum;
        int left= sumNumbers(root.left,sum);
        int right=sumNumbers(root.right,sum);
        return left+right;
    }
}