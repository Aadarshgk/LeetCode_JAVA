class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int count=4,res=0,pad=1;
        while(count>0){
            int minVal=num1%10;
            minVal=Math.min(minVal,num2%10);
            minVal=Math.min(minVal,num3%10);
            res+=(pad*minVal);
            pad*=10;
            num1/=10;
            num2/=10;
            num3/=10;
            count--;
        }
        return res;
    }
}