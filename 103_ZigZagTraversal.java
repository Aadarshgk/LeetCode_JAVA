class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> res= new ArrayList<>();
        int count=0;
        ArrayList<TreeNode> q= new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> ans= new ArrayList<>();
            int size= q.size();
            if(count%2==0){
                for(int i=size-1;i>=0;i--){
                    TreeNode temp= q.remove(i);
                    if(temp.right!=null) q.add(temp.right);
                    if(temp.left!=null) q.add(temp.left);
                    ans.add(0,temp.val);
                }
            }else{
                for(int i=size-1;i>=0;i--){
                    TreeNode temp= q.remove(i);
                    if(temp.left!=null) q.add(temp.left);
                    if(temp.right!=null) q.add(temp.right);
                    ans.add(0,temp.val);
                }
            }
            count++;
            res.add(ans);
        }
        return res;
    }
}