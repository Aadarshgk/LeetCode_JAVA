// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         if(root==null) return new ArrayList<>();
//         Queue<TreeNode> q= new LinkedList<>();
//         List<Integer> res=new ArrayList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//             int size=q.size();
//             for(int i=0;i<size-1;i++){
//                 if(q.peek().left!=null) q.add(q.peek().left);
//                 if(q.peek().right!=null) q.add(q.peek().right);
//                 q.remove();
//             }
//             if(q.peek().left!=null) q.add(q.peek().left);
//             if(q.peek().right!=null) q.add(q.peek().right);
//             res.add(q.remove().val);
//         }
//         return res;        
//     }
// }


//Optimal solution to this problem
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) {
            return;
        }
       
        if (currDepth == result.size()) {
            result.add(curr.val);
        }
 
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
    }
}

//iterates through each level and checks size of res, if equal to depth then add the node else next depth