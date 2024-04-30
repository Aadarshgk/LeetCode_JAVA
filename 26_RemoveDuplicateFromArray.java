class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0,j=-1,len=nums.length;
        while(i<len-1){
            if(nums[i]!=nums[i+1]){
                nums[++j]=nums[i];
            }
            i++;
        }
        nums[++j]=nums[len-1];
        return ++j;
    }
}