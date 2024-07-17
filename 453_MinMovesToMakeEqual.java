class Solution {
    public int minMoves(int[] nums) {
        int min=Integer.MAX_VALUE,sum=0;
        for(int a: nums){
            if(min>a){
                min=a;
            }
        }
        for(int a: nums){
            sum+= a-min;
        }
        return sum;
    }
}