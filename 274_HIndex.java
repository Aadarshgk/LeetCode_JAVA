import java.util.Arrays;
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i=0,len=citations.length;
        while(i<len){
            if(citations[i]<len-i){
                i++;
            }else{
                return len-i;
            }
        }
        return 0;
    }
}