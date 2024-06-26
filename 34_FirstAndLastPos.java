class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len=nums.length;
        if(len==0) return new int[] {-1,-1};
        int low=0,high=len-1,mid=low+(high-low)/2;
        while(low<=high){
            mid= low+(high-low)/2;
            if(nums[mid]==target){
                break;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }       

        if(low>high){
            return new int[] {-1,-1};
        }

        int i=mid,j=mid;
        while(i>=0 && nums[i]==target){
            i--;
        }
        

        while(j<len && nums[j]==target){
            j++;
        }
        
        return new int[]{i+1,j-1};
    }
}