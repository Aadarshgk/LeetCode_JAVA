import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] nums= Arrays.copyOf(arr,arr.length);
        Arrays.sort(nums);
        HashMap<Integer,Integer> map= new HashMap<>();
        int k=1;
        int prev=Integer.MIN_VALUE;
        for(int a: nums){
            if(a==prev){
                continue;
            }
            map.put(a,k++);
            prev=a;
        }

        for(int i=0;i<arr.length;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}