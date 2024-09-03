import java.util.Arrays;
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        return nums[len/2];
    }
}
//importance of understanding question and interpreting it rightly


//initial idea
// for(int i=0;i<len-1;i++){
//     int count=0;
//     while(i<len-1 && nums[i]==nums[i+1]){
//         i++;
//         count++;
//     }
//     if(count>=len/2){
//         return nums[i-1];
//     }
// }
// return nums[len-1];