class Solution {
    public int binarySearch(int[] nums, int low,int high,int target){
        int mid= low+ (high-low)/2;
        if(low<=high){
            if(nums[mid]==target){
                return mid;
            }else if(target>nums[mid]){
                if(target>nums[high] && nums[mid]<=nums[high]){
                    return binarySearch(nums,low,mid-1,target);
                }else{
                    return binarySearch(nums,mid+1,high,target);
                }
            }else{
                if(target<nums[low] && nums[mid]>=nums[low]){
                    return binarySearch(nums,mid+1,high,target);
                }else{
                    return binarySearch(nums,low,mid-1,target);
                }
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }
}