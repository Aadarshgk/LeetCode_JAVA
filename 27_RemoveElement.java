class Solution {
    public int removeElement(int[] nums, int val) {
        int len= nums.length,i=0;
        while(i<len){
            if(nums[i]==val){
                replace(nums,i,len);
                len--;
            }else{
                i++;
            }
        }
        return len;
    }
    public void replace(int[] nums, int i, int len){
        while(i<len-1){
            nums[i]=nums[++i];
        }
    }
}