class Solution {
    public boolean check(int[] nums) {
        int len=nums.length,pivot=0;
        for(int i=1;i<len;i++){
            if(nums[i]<nums[i-1]){
                pivot=i;
                break;
            }
        }

        if(pivot==0) return true;

        int i=pivot;
        do{
            if(nums[i]>nums[(i+1)%len]){
                return false;
            }
            i=(i+1)%len;
        }while(i!=pivot-1);
        return true;
    }
}