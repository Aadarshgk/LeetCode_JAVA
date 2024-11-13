import java.util.Arrays;
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int len=nums.length;
        int res=0;

        for(int i=0;i<len-1;i++){
            int l=lowerBound(nums,i+1,nums[i],lower);
            int r=upperBound(nums,i+1,nums[i],upper);
            if(l==-1 || r==-1) continue;
            res+=r-l;
        }

        return res;

    }

    public int lowerBound(int[] nums,int low, int val, int lower){
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(val+nums[mid]>=lower){
                high=mid-1;
                ans=mid;
            }else{
                low=mid+1;
            }
        }

        return ans;
    }
    
    public int upperBound(int[] nums,int low, int val, int upper){
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(val+nums[mid]<=upper){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return ans;
    }
}