import java.util.Arrays;
class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int maxWin=Integer.MIN_VALUE;
        int l=0,r=0,len=nums.length;
        while(l<=r && r<len){
            if((nums[r]-nums[l]) <= (2*k)){
                r++;
            }else{
                maxWin=Math.max(maxWin,r-l);
                l++;
            }
        }

        maxWin=Math.max(maxWin,r-l);
        return maxWin;
    }
}