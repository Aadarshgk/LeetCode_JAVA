//most efficient soln- Boyer Moore's voting algorithm - O(n)
class Solution {
    public int majorityElement(int[] nums) {
        int count=0,el1=0,len=nums.length;
        for(int i=0;i<len;i++){
            if(count==0){
                el1=nums[i];
            }
            
            if(el1==nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return el1;
    }
}

//second solution - O(nlogn)
// class Solution {
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         int len=nums.length;
//         return nums[len/2];
//     }
// }
//importance of understanding question and interpreting it rightly


//initial idea
// Arrays.sort(nums);
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