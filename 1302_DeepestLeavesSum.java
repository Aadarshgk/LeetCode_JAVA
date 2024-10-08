class Solution {
    
    int sum=0;
    int maxLevel=0;
    public int deepestLeavesSum(TreeNode root) {
        bfs(root,0);
        return sum;
    }

    public void bfs(TreeNode root, int level){
        if(root==null) return ;

        if(level>maxLevel){
            maxLevel=level;
            sum=root.val;
        }else if(level==maxLevel){
            sum+=root.val;
        }

        bfs(root.left,level+1);
        bfs(root.right,level+1);
    }
}