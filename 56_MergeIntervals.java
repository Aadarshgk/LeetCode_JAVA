import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
//Initial brute force solution
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a-> a[0]));  
        List<int[]> res= new ArrayList<>();
        res.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>res.get(res.size()-1)[1]){
                res.add(intervals[i]);
                continue;
            }else{
                res.get(res.size()-1)[1]=Math.max(res.get(res.size()-1)[1], intervals[i][1]);
            }
        }

        int[][] result= new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            result[i]=res.get(i);
        }
        return result;
    }
}