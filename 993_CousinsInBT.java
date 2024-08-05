import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            boolean xFound=false, yFound=false;
            int len= q.size();
            for(int i=0;i<len;i++){
                boolean leftChild=false,rightChild=false;
                TreeNode temp= q.remove();
                if(temp.left!=null) {
                    q.add(temp.left);
                    if(temp.left.val==x || temp.left.val==y) leftChild=true;
                }
                if(temp.right!=null) {
                    q.add(temp.right);
                    if(temp.right.val==x || temp.right.val==y) rightChild=true;
                }
                if(temp.val==x) xFound=true; 
                else if(temp.val==y) yFound=true;
                if(leftChild && rightChild) return false;
            }
            if(xFound || yFound) return xFound && yFound;            
        }
        return false;        
    }
}