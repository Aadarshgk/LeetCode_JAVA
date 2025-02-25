class Solution {
    public int numOfSubarrays(int[] arr) {
        int odd=0,even=0;
        int len=arr.length;
        long[] prefix= new long[len];
        prefix[0]=arr[0];
        long res=0;
        if((arr[0]&1)==1){
            odd++;
            res++;
        }else{
            even++;
        }

        for(int i=1;i<len;i++){
            prefix[i]=prefix[i-1]+arr[i];
            if((prefix[i]&1)==1){
                res+=even+1;
                odd++;
            }else{
                res+=odd;
                even++;
            }
        }
        res=(res%1000000007);
        return (int)res;
    }

}