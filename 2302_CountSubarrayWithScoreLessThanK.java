class Solution {
    public long countSubarrays(int[] nums, long k) {
        long sum=0,res=0;
        int i=0,j=0,len=nums.length;
        for(j=0;j<len;j++){
            sum+=nums[j];
            int size=j-i+1;
            while(sum*size >=k){
                sum-=nums[i++];
                size--;
            }
            res+=size;
        }
        return res;
    }
}