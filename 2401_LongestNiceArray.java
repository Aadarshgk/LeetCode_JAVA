// //Brute force
// class Solution {
//     public int longestNiceSubarray(int[] nums) {
//         int[] ar = new int[32];
//         int i = 0, j = 0, len = nums.length, max = 1;

//         for (i = 0; i < len; i++) {
//             int num = nums[i];

//             for (int k = 0; k < 32; k++) {
//                 if ((num & (1 << k)) > 0) {
//                     ar[k]++;
//                 }
//             }

//             boolean flag = false;
//             for(int k=0; k<32; k++){
//                 if(ar[k] > 1){
//                     flag = true;
//                     break;
//                 }
//             }

//             if (flag) {
//                 max = Math.max(max, i - j);
//                 while (flag) {
//                     num = nums[j++];
//                     for (int k = 0; k < 32; k++) {
//                         if ((num & (1 << k)) > 0) {
//                             ar[k]--;
//                         }
//                     }

//                     flag = false;
//                     for(int k=0; k<32; k++){
//                         if(ar[k] > 1){
//                             flag = true;
//                             break;
//                         }
//                     }
//                 }
//             }
//         }
//         max = Math.max(max, i - j); 
//         return max;
//     }
// }

class Solution {
    public int longestNiceSubarray(int[] nums) {
        int curSum=0,xorSum=0,left=0,right=0,len=nums.length,max=0;
        while(right<len){
            curSum+=nums[right];
            xorSum^=nums[right++];
            while(curSum!=xorSum){
                curSum-=nums[left];
                xorSum^=nums[left++];
            }
            max=Math.max(max,right-left);
        }
        return max;
    }
}