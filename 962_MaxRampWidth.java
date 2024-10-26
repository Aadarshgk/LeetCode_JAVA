class Solution {
    public int maxWidthRamp(int[] nums) {
        int len=nums.length;
        int[] ar= new int[len];
        ar[len-1]=nums[len-1];
        for(int i=len-2;i>=0;i--){
            ar[i]=Math.max(ar[i+1],nums[i]);
        }   

        int maxWidth=0,left=0,right=1;

        while(right<len){
            while(left<right && nums[left] > ar[right]){
                left++;
            }

            maxWidth=Math.max(maxWidth, right-left);
            right++;
        }

        return maxWidth;
    }
}