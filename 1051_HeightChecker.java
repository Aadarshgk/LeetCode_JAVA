import java.util.Arrays;
class Solution {
    public int heightChecker(int[] heights) {
        int len=heights.length,count=0,i=0;
        int[] order=new int[len];
        while(i<len){
            order[i]=heights[i++];
        }
        Arrays.sort(order);
        i=0;
        while(i<len){
            if(order[i]!=heights[i]){
                count++;
            }
            i++;
        }  
        return count;
    }
}