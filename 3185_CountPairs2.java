class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long[] ar= new long[24];
        for(int i=0;i<24;i++){
            ar[i]=0;
        }
        long count=0;
        int i=0,len=hours.length;
        while(i<len){
            int rem=hours[i]%24;
            count+=ar[(24-rem)%24];
            ar[rem]++;
            i++;
        }
        return count;
    }
}