//O(1) soln
class Solution {
    public void rotate(int[] nums, int k) {
        int len=nums.length;
        k=k%len;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
    }

    public void reverse(int[] nums, int i, int j){
        while(i<=j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}

// class Solution {
//     public void rotate(int[] nums, int k) {
//         int len=nums.length;
//         k=k%len;
//         if(nums.length==0|| k==0 || nums.length==1) return;
//         int i=len-k,j=0;
//         int[] ar= new int[k];
//         while(i<len){
//             ar[j]=nums[i];
//             i++;j++;
//         }      
//         i=len-k-1;  
//         while(i>=0){
//             nums[i+k]=nums[i];
//             i--;
//         }
//         i=0;
//         while(i<k){
//             nums[i]=ar[i++];
//         }
//     }
// }