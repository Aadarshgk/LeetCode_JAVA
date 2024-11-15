class Solution {
    public int findLengthOfShortestSubarray(int[] ar) {
        int i=0,len=ar.length,j=len-1;

        while(j>0 && ar[j]>=ar[j-1]){
            j--;
        }  

        int res=j;
        while(i<j){
            while(j<len && ar[i]>ar[j]){
                j++;
            }

            res= Math.min(res, j-i-1);

            i++;
            if(ar[i]<ar[i-1]) break;
        } 

        return res;
    }
}