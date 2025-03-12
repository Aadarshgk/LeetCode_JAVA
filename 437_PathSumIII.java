import java.util.HashMap;
class Solution {
    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> map=new HashMap<>();
        map.put(0L,1);
        helper(root,targetSum,0,map);
        return count;
    }

    public void helper(TreeNode root, int target,long sum, HashMap<Long,Integer> map){
        if(root==null) return;

        sum+=root.val;
        if(map.containsKey(sum-target)){
            count+=map.get(sum-target);   
        }
        int val=map.getOrDefault(sum,0);
        map.put(sum,val+1);
        helper(root.left,target,sum,map);
        helper(root.right,target,sum,map);
        if(val==0){
            map.remove(sum);
            return;
        }
        map.put(sum,val);
    }
}