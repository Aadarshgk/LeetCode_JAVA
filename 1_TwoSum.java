// 
import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0,len=nums.length;
        HashMap<Integer,Integer> set= new HashMap<>();
        while(i<len){
            if(set.containsKey(target-nums[i])){
                return new int[]{i,set.get(target-nums[i])};
            }
            set.put(nums[i],i);
            i++;
        }
        return null;
    }
}