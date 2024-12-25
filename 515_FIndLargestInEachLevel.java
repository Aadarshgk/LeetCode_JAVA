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
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return new ArrayList<Integer>();

        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> res= new ArrayList<>();
        
        q.add(root);

        while(!q.isEmpty()){
            int len=q.size();
            int maxVal=Integer.MIN_VALUE;
            for(int i=0;i<len;i++){
                TreeNode node= q.poll();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                maxVal=Math.max(maxVal,node.val);
            }
            res.add(maxVal);
        }

        return res;
    }
}