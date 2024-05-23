class Solution {
    public int findPeakElement(int[] nums) {
        int l=0,r=nums.length-1,mid;
        while(l<r){
            mid=l+(r-l)/2;
            if(nums[mid]>nums[mid+1]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}