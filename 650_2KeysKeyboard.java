class Solution {
    public int minSteps(int n) {
        int sum=0,i=2;
        while(n>0 && i<=n){
            if(n%i==0){
                sum+=i;
                n/=i;
            }else{
                i++;
            }
        }
        return sum;
    }
}