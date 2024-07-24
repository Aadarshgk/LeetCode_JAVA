class Solution {
    public int maxProduct(int[] nums) {
        int min=nums[0], max=nums[0], res=nums[0];
        int len=nums.length;
        for(int i=1;i<len;i++){
            if(nums[i]<0){
                int temp=max;
                max=min;
                min=temp;
            }
            max=Math.max(nums[i],max*nums[i]);
            min=Math.min(nums[i],min*nums[i]);
            res=Math.max(max,res);
        }
        return res;
    }
}