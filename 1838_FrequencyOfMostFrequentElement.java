import java.util.Arrays;
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0,r=0, res=0, len=nums.length;
        long total=0;
        while(r<len){
            total+=nums[r];

            while((long)nums[r]* (r-l+1) > total+k){
                total-=nums[l];
                l++;
            }
            res= Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
} 