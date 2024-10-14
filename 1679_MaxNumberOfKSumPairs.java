import java.util.Arrays;
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count=0,i=0,j=nums.length-1;
        while(i<j){
            if(nums[i]+nums[j]==k){
                count++;
                i++;
                j--;
            }else if(nums[i]+nums[j] > k){
                j--;
            }else{
                i++;
            }
        }
        return count;
    }
}