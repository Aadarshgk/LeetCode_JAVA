class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new LinkedList<List<Integer>>();
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> subList=new LinkedList<Integer>();
            for(int i=0;i<size;i++){
                if(q.peek().left!=null) q.add(q.peek().left);  
                if(q.peek().right!=null) q.add(q.peek().right);
                subList.add(q.poll().val);  
            }
            res.add(subList);
        }
        return res;
    }
}