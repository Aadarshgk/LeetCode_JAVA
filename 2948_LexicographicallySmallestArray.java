import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int len=nums.length;
        int[][] copySorted= new int[len][2];
        int k=0;
        while(k<len){
            copySorted[k]=new int[]{nums[k],k++};
        }
        Arrays.sort(copySorted,(a,b)->{return a[0]-b[0];});

        int i=0,j=1;
        while(j<len){
            List<Integer> temp=new ArrayList<>();
            temp.add(copySorted[i][1]);
            
            while(j<len && Math.abs(copySorted[j][0]-copySorted[j-1][0])<=limit){
                temp.add(copySorted[j++][1]);
            }

            Collections.sort(temp);
            for(int n: temp){
                nums[n]=copySorted[i++][0];
            }
            j++;
        }

        return nums;
    }
}