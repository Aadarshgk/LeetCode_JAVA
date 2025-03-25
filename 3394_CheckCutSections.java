import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> x= new ArrayList<>();
        List<int[]> y= new ArrayList<>();

        for(int[] rect: rectangles){
            x.add(new int[]{rect[0],rect[2]});
            y.add(new int[]{rect[1],rect[3]});
        }

        return (helper(x)||helper(y));
    }

    public boolean helper(List<int[]> list){
        List<int[]> temp=new ArrayList<>();
        Collections.sort(list,(a,b)->a[0]-b[0]);
        temp.add(list.get(0));
        for(int i=1;i<list.size();i++){
            int len=temp.size();
            if(temp.get(len-1)[1]<=list.get(i)[0]){
                temp.add(list.get(i));
            }else{
                temp.get(len-1)[1]=Math.max(temp.get(len-1)[1],list.get(i)[1]);
            }
        }

        return temp.size()>=3;
    }
}