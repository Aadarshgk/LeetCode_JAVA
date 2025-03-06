import java.util.Arrays;
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int len=grid.length;
        boolean[] mem= new boolean[len*len + 1];
        int[] res= new int[2];
        Arrays.fill(mem,false);
        for(int[] ar: grid){
            for(int n: ar){
                if(!mem[n]){
                    mem[n]=true;
                }else{
                    res[0]=n;
                }
            }
        }

        for(int i=1;i<=len*len;i++){
            if(!mem[i]){
                res[1]=i;
            }
        }

        return res;
    }
}