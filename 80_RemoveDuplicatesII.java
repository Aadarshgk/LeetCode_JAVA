class Solution {
    public int removeDuplicates(int[] nums) {
        int i=1,j=0,len=nums.length;
        while(i<len){
            if(nums[i]==nums[j]){
                nums[++j]=nums[i++];
                while(i<len && nums[i]==nums[j]){
                    i++;
                }
            }else{
                nums[++j]=nums[i++];
            }
        }
        return j+1;
    }
}