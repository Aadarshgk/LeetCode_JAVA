class Solution {
    public void rotate(int[] nums, int k) {
        int len=nums.length;
        k=k%len;
        if(nums.length==0|| k==0 || nums.length==1) return;
        int i=len-k,j=0;
        int[] ar= new int[k];
        while(i<len){
            ar[j]=nums[i];
            i++;j++;
        }      
        i=len-k-1;  
        while(i>=0){
            nums[i+k]=nums[i];
            i--;
        }
        i=0;
        while(i<k){
            nums[i]=ar[i++];
        }
    }
}