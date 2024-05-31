class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i=0,len=nums.length,k=0;
        int[] res= new int[2];
        while(i<=len-1){
            if(i==len-1){
                res[1]=nums[i];
                break;
            }

            if(nums[i]!=nums[i+1]){
                res[k++]=nums[i++];
            }else{
                i+=2;
            }
        }
        return res;
    }
}