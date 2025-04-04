// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     TreeNode res;
//     public TreeNode lcaDeepestLeaves(TreeNode root) {
//         Queue<TreeNode> q=new LinkedList<>();
//         List<List<TreeNode>> tree= new ArrayList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//             int len=q.size();
//             List<TreeNode> list=new ArrayList<>();
//             for(int i=0;i<len;i++){
//                 TreeNode node=q.poll();
//                 if(node.left!=null) q.add(node.left);
//                 if(node.right!=null) q.add(node.right);
//                 list.add(node);
//             }
//             tree.add(list);
//         }

//         int len1=tree.size();
//         int len2= tree.get(len1-1).size();
//         if(len2 == 1) return tree.get(len1-1).get(0);
//         TreeNode a=tree.get(len1-1).get(0);
//         TreeNode b=tree.get(len1-1).get(len2-1);
//         helper(root,a,b);
//         return res;
//     }

//     public boolean helper(TreeNode root, TreeNode a, TreeNode b){
//         if(root==null) return false;
//         boolean anc=false,left=false,right=false;
//         if(root==a || root==b){
//             anc=true;
//         }

//         left=helper(root.left,a,b);
//         right=helper(root.right,a,b);
        
//         if((anc && left) || (anc && right) || (left&&right)){
//             res=root;
//         }

//         return anc || left || right;
//     }
// }


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode res;
    int max=-1;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root,0);
        return res;
    }

    public int dfs(TreeNode root, int depth){
        if(root==null){
            max=Math.max(depth,max);
            return depth;
        }

        int left=dfs(root.left,depth+1);
        int right=dfs(root.right,depth+1);
        if(left==right && left==max){
            res=root;
        }
        return Math.max(left,right);
    }
}