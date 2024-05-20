class Solution {
    public boolean isPrime(int num){
        if(num==2) return true;
        if(num<2) return false;
        int i=2;
        while(i*i<=num){
            if(num%i==0){
                return false;
            }
            i++;
        }
        return true;
    }
    public int diagonalPrime(int[][] nums) {
        int i=0,max=0,len=nums.length-1;
        while(i<=len){
            if(max<nums[i][i] && isPrime(nums[i][i])){
                max=(max<nums[i][i])?nums[i][i]:max;
            }
            if(max<nums[i][len-i] && isPrime(nums[i][len-i])){
                max=(max<nums[i][len-i])?nums[i][len-i]:max;
            }
            i++;
        }
        return max;
    }
}