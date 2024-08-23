import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            double num=0;
            int len= q.size();
            for(int i=0;i<len;i++){
                TreeNode node= q.remove();
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                num+=node.val;
            }
            num/=len;
            res.add(num);
        }
        return res;
    }
}