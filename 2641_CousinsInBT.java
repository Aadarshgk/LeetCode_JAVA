import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        root.val=0;
        q.add(root);
        while(!q.isEmpty()){
            int sum=0;
            int len=q.size();
            for(int i=0;i<len;i++){
                TreeNode node=q.remove();
                if(node.left!=null) sum+=node.left.val;
                if(node.right!=null) sum+=node.right.val;
                q.add(node);
            }

            for(int i=0;i<len;i++){
                TreeNode node=q.remove();
                int sib=0;
                if(node.left!=null){
                    sib+=node.left.val;
                    q.add(node.left);
                }

                if(node.right!=null){
                    sib+=node.right.val;
                    q.add(node.right);
                }

                if(node.left!=null) node.left.val=sum-sib;
                if(node.right!=null) node.right.val=sum-sib;
            }
        }

        return root;
    }
}