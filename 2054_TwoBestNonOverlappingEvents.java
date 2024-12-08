import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int maxTwoEvents(int[][] events) {
        List<int[]> tl=new ArrayList<>();
        for(int[] ar: events){
            tl.add(new int[]{ar[0],1,ar[2]});
            tl.add(new int[]{ar[1]+1,-1,ar[2]});
        }
        Collections.sort(tl,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        int maxVal=0;
        int maxSeen=0;
        for(int[] ar: tl){
            if(ar[1]==1){
                maxVal=Math.max(maxSeen+ar[2],maxVal);
            }else{
                maxSeen=Math.max(ar[2],maxSeen);
            }
        }
        return maxVal;
    }
}