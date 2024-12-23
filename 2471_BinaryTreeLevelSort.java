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
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int minimumOperations(TreeNode root) {
        if(root==null) return 0;
        int count=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int len=q.size();
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode node= q.poll();
                l.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }

            }
            count+=helper(l);
        }

        return count;
    }

    public int helper(List<Integer> list){
        List<Integer> temp= new ArrayList<>(list);
        HashMap<Integer,Integer> map=new HashMap<>();
        int len= list.size(),res=0;
        for(int i=0;i<len;i++){
            map.put(list.get(i),i);
        }

        boolean[] vis=new boolean[len];
        Arrays.fill(vis,false);

        Collections.sort(temp);

        for(int i=0;i<len;i++){
            
            if(vis[i] || map.get(temp.get(i))==i) continue;

            int id=i,count=0;
            while(!vis[id]){
                vis[id]=true;
                id=map.get(temp.get(id));
                count++;
            }
            res+=count-1;
        }

        return res;

    }
}