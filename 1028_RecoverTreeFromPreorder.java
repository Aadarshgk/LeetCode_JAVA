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
    public TreeNode recoverFromPreorder(String traversal) {
        TreeNode root=new TreeNode();
        add(root,traversal,0,0,traversal.length());
        return root;
    }

    public int add(TreeNode root,String str,int level,int pos,int len){
        if(pos==len){
            return pos;
        }

        int val=0,i=pos;
        for(i=pos;i<len;i++){
            char c=str.charAt(i);
            if(c=='-'){
                break;
            }else{
                val=(val*10)+(c-'0');
            }
        }

        root.val=val;

        int nextLevel=0;
        while(i<len && str.charAt(i)=='-'){
            i++;
            nextLevel++;
        }

        if(i==len) return i;

        if(nextLevel<=level){
            return i-nextLevel;
        }

        root.left=new TreeNode();
        int newPos=add(root.left,str,nextLevel,i,len);

        if(newPos==len) return newPos;

        nextLevel=0;
        for(i=newPos;i<len;i++){
            if(str.charAt(i)=='-'){
                nextLevel++;
            }else{
                break;
            }
        }

        if(nextLevel<=level){
            return i-nextLevel;
        }else{
            root.right=new TreeNode();
            return add(root.right,str,nextLevel,i,len);
        }
    }
}