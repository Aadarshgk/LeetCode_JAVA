class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] prefix=new int[nums.length];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1];
            if((nums[i-1]-nums[i])%2==0){
                prefix[i]++;
            }
        }
        boolean[] res=new boolean[queries.length];
        int k=0;
        for(int[] ar: queries){
            if(prefix[ar[1]]-prefix[ar[0]] > 0){
                res[k++]=false;
            }else{
                res[k++]=true;
            } 
        }
        return res;       
    }
}

//Initial soln - Time limit exceeded 
// class Solution {
//     public boolean[] isArraySpecial(int[] nums, int[][] queries) {
//         int len= queries.length;
//         boolean[] res= new boolean[len];
//         Arrays.fill(res,true);
//         int k=-1;

//         for(int[] ar: queries){
//             ++k;
//             for(int i=ar[0];i<ar[1];i++){
//                 if((nums[i] - nums[i+1])%2==0){
//                     res[k]=false;
//                     break;
//                 }
//             }
//         }
//         return res;
//     }
// }