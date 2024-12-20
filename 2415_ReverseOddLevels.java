import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

//DFS soln
// class Solution {

//     public TreeNode reverseOddLevels(TreeNode root) {
//         traverseDFS(root.left, root.right, 0);
//         return root;
//     }

//     private void traverseDFS(
//         TreeNode leftChild,
//         TreeNode rightChild,
//         int level
//     ) {
//         if (leftChild == null || rightChild == null) {
//             return;
//         }
//         //If the current level is odd, swap the values of the children.
//         if (level % 2 == 0) {
//             int temp = leftChild.val;
//             leftChild.val = rightChild.val;
//             rightChild.val = temp;
//         }

//         traverseDFS(leftChild.left, rightChild.right, level + 1);
//         traverseDFS(leftChild.right, rightChild.left, level + 1);
//     }
// }


//BFS soln
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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int level=0;

        while(!q.isEmpty()){
            int len=q.size();
            List<TreeNode> list= new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode node=q.poll();
                list.add(node);
                if(node.left!=null){
                    q.add(node.left);
                    q.add(node.right);
                }    
            }

            if(level%2==1){
                int l=0,r=list.size()-1;
                while(l<r){
                    int temp=list.get(l).val;
                    list.get(l).val=list.get(r).val;
                    list.get(r).val=temp;
                    l++;
                    r--;
                }
            }
            level++;
        }

        return root;
    }
}