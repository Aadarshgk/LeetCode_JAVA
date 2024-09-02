//cycle approach
class Solution {
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];

        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);

        slow=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}

//hashing approach
// class Solution {
//     public int findDuplicate(int[] nums) {
//         boolean[] res= new boolean[nums.length];
//         Arrays.fill(res,false);
//         for(int a: nums){
//             if(res[a]){
//                 return a;
//             }
//             res[a]=true;
//         }
//         return 0;
//     }
// }