class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int count=0,len=hours.length;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if((hours[i]+hours[j])%24==0){
                    count++;
                }
            }
        }
        return count;
    }
}