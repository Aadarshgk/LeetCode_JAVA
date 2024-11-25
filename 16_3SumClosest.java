import java.util.Arrays;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE,len=nums.length;
        for(int i=0;i<len;i++){
            int j=i+1,k=len-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(Math.abs(sum-target)<Math.abs(min-target)){
                    min=sum;
                }
                
                if(sum<target){
                    j++;
                }else if(sum>target){
                    k--;
                }else{
                    return sum;
                }
            }
        }
        return min;
    }
}