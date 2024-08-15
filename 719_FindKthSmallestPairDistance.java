import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len=nums.length;
        int minVal=0,maxVal=nums[len-1]-nums[0];

        while(minVal<=maxVal){
            int midVal=minVal+(maxVal-minVal)/2;
            int l=0,r=0,count=0;
            while(r<len){
                if(nums[r]-nums[l]>midVal){
                    l++;
                }else{
                    count+=r-l;
                    r++;
                }
            }
            if(count<k){
                minVal=midVal+1;
            }else{
                maxVal=midVal-1;
            }
        }
        return minVal;
    }
}