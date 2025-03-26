import java.util.List;
import java.util.ArrayList;
import java.util.COllections;
class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list=new ArrayList<>();
        int rem=grid[0][0]%x;
        for(int[] ar: grid){
            for(int n: ar){
                if(n%x!=rem) return -1;
                list.add(n);
            }
        }

        Collections.sort(list);
        int len=list.size();
        int num=list.get(len/2);
        int res=0;
        for(int n: list){
            res+=Math.abs(n-num)/x;
        }

        return res;
    }
}