class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        List<Integer> res=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size-1;i++){
                if(q.peek().left!=null) q.add(q.peek().left);
                if(q.peek().right!=null) q.add(q.peek().right);
                q.remove();
            }
            if(q.peek().left!=null) q.add(q.peek().left);
            if(q.peek().right!=null) q.add(q.peek().right);
            res.add(q.remove().val);
        }
        return res;        
    }
}