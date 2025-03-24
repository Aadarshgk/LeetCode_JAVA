import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        List<int[]> list=new ArrayList<>();
        list.add(meetings[0]);
        for(int[] m: meetings){
            int size=list.size();
            if(list.get(size-1)[1]<m[0]){
                list.add(m);
            }else {
                list.get(size-1)[1]=Math.max(list.get(size-1)[1],m[1]);
            }
        }   

        int res=list.get(0)[0]-1;
        int len=list.size();
        for(int i=1;i<len;i++){
            res+=list.get(i)[0]-list.get(i-1)[1]-1;
        }

        res+=days-list.get(len-1)[1];

        return res;

    }
}