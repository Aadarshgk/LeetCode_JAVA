import java.util.Arrays;
class Solution {
    public int longestConsecutive(int[] nums) {
        int len=nums.length;
        if(len==0||len==1) return len;
        Arrays.sort(nums);
        int i=1;
        int ctr=1,largest=1;
        int prev=nums[0];
        while(i<len){
            while(i<len && nums[i]==nums[i-1]){
                i++;
            }

            if(i<len && nums[i]==prev+1){
                ctr++;
            }else{
                largest=Math.max(largest,ctr);
                ctr=1;
            }

            if(i<len){
                prev=nums[i++];
            }
        }
        largest=Math.max(largest,ctr);
        return largest;
    }
}