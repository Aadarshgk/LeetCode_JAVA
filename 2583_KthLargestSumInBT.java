import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq= new PriorityQueue<>((a,b)-> Long.compare(a,b));
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int len=q.size();
            long sum=0;
            for(int i=0;i<len;i++){
                TreeNode node=q.remove();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                sum+=(long)node.val;
            }
            pq.add(sum);
            if(pq.size()>k){
                pq.remove();
            }
        }

        if(pq.size()<k) return -1;
        return pq.remove();

    }
}