import java.util.PriorityQueue;
import java.util.Arrays;
class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->{
            if(nums[a]!=nums[b]){
                return nums[a]-nums[b];
            }
            return a-b;
        });
        int len=nums.length;
        for(int i=0;i<len;i++){
            pq.add(i);
        }

        boolean[] set= new boolean[len];
        Arrays.fill(set,false);
        long res=0;
        while(!pq.isEmpty()){
            int n=pq.poll();
            if(!set[n]){
                // set[n]=true;
                if(n!=0){
                    set[n-1]=true;
                }

                if(n!=len-1){
                    set[n+1]=true;
                }
                res+=nums[n];
            }
        }

        return res;
    }
}