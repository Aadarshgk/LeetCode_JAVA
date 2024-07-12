import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> prev= new ArrayList<>();
        prev.add(1);
        res.add(prev);
        return pascal(prev,numRows,1,res);
    }

    public List<List<Integer>> pascal(List<Integer> prev, int n, int count,List<List<Integer>> res){
        if(count==n){
            return res;
        }
        List<Integer> row=new ArrayList<>();
        row.add(1);

        int len=prev.size();
        for(int i=1;i<len;i++){
            row.add(prev.get(i-1)+prev.get(i));
        }
        row.add(1);
        res.add(row);
        return pascal(row,n,++count,res);        
    }
}