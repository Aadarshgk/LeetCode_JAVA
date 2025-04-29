class Solution {
    public long countSubarrays(int[] nums, int k) {
        long res=0;
        int count=0,i=0,j=0,max=0,len=nums.length;
        for(int l=0;l<len;l++){
            max=(max<nums[l])?nums[l]:max;
        }

        for(j=0;j<len;j++){
            if(nums[j]==max) count++;
            while(count>=k){
                res+=len-j;
                if(nums[i]==max) count--;
                i++;
            }
        }

        return res;
    }
}