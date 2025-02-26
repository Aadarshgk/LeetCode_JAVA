//Kadane's algorithm
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum=0,max=Integer.MIN_VALUE;
        for(int n: nums){
            sum+=n;
            if(sum>max){
                max=sum;
            }

            if(sum<0){
                sum=0;
            }
        }

        int min=Integer.MAX_VALUE;
        sum=0;
        for(int n: nums){
            sum+=n;
            if(sum<min){
                min=sum;
            }

            if(sum>0){
                sum=0;
            }
        }

        return Math.max(max,Math.abs(min));
    }
}

//Alternative min-max soln
// class Solution {
//     public int maxAbsoluteSum(int[] nums) {
//         int sum=0,max=0,min=0;
//         for(int n: nums){
//             sum+=n;
//             if(sum<min){
//                 min=sum;
//             }
//             if(sum>max){
//                 max=sum;
//             }
//         }

//         return Math.abs(max)+Math.abs(min);
//     }
// }