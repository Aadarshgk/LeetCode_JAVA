class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        for(int a: nums){
            sum+=a;
        }

        int val= (nums.length)*(nums.length+1)/2;
        return Math.abs(val-sum);
    }
}

//XOR soln
// class Solution{
//     public int missingNumber(int[] nums){
//         int res=nums.length;
//         for(int a: nums){
//             res= (res^a);
//         }
//         return res;
//     }
// }