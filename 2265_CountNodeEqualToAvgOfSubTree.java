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
    
    // class Pair{
    //     int sum;
    //     int size;

    //     public Pair(int sum,int size){
    //         this.sum=sum;
    //         this.size=size;
    //     }
    // }
    
    int count=0;
    public int averageOfSubtree(TreeNode root) {
        average(root);
        return count;
    }

    public int[] average(TreeNode root){
        if(root==null) return new int[]{0,0};

        int[] left=average(root.left);
        int[] right=average(root.right);

        int div=left[1]+ right[1] +1;
        int sum=root.val + left[0] + right[0];
        int avg= sum/div;

        if(avg==root.val) count++;

        return new int[]{sum,div};

    }


}