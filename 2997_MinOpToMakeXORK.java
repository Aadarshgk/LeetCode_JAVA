// class Solution {
//     public int minOperations(int[] nums, int k) {
//         int[] kBits=new int[32];
//         int[] nBits=new int[32];

//         for(int i=0;i<32;i++){
//             if((k&(1<<i))!=0){
//                 kBits[i]++;
//             }
//         }

//         for(int n: nums){
//             for(int i=0;i<32;i++){
//                 if((n&(1<<i))!=0){
//                     nBits[i]++;
//                 }
//             }
//         }

//         int count=0;
//         for(int i=0;i<32;i++){
//             if(kBits[i]==0){
//                 if(nBits[i]%2==1) count++;
//             }else{
//                 if(nBits[i]%2==0) count++;
//             }
//         }

//         return count;
//     }
// }


//Optimal code
class Solution {
    public int minOperations(int[] nums, int k) {
        int x=0;

        for(int n: nums){
            x^=n;
        }

        int val=x^k;

        int count=0;
        while(val>0){
            count+=(val&1);
            val=(val>>1);
        }

        return count;
    }
}