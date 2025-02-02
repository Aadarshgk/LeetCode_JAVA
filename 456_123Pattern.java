import java.util.Stack;
class Solution {
    public boolean find132pattern(int[] nums) {
        int len=nums.length;
        int third=Integer.MIN_VALUE;
        Stack<Integer> stack=new Stack<>();
        for(int i=len-1;i>=0;i--){
            if(nums[i]<third) return true;
            while(!stack.isEmpty() && stack.peek()<nums[i]){
                third=stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}