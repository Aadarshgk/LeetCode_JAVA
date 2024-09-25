class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int left=0,len=nums.length,right=len-1;
        int[] res= new int[len];
        for(int i=0;i<len;i++){
            if(nums[i]<pivot){
                res[left++]=nums[i];
            }

            if(nums[len-i-1]>pivot){
                res[right--]=nums[len-i-1];
            }
        }

        while(left<=right){
            res[left++]=pivot;
            res[right--]=pivot;
        }

        return res;
    }
}


//initial code
// class Solution {
//     public int[] pivotArray(int[] nums, int pivot) {
//         int len=nums.length;
//         int less=0,more=0;
//         for(int a: nums){
//             if(a<pivot){
//                 less++;
//             }else if(a>pivot){
//                 more++;
//             }
//         }

//         int[] res= new int[len];
//         int i=0,j=less+(len-more-less),k=less;
//         for(int a: nums){
//             if(a<pivot){
//                 res[i++]=a;
//             }else if(a>pivot){
//                 res[j++]=a;
//             }else{
//                 res[k++]=a;
//             }
//         }
//         return res;

//     }
// }