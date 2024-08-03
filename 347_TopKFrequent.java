import java.util.HashMap;
import java.util.PriorityQueue;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int a: nums){
            int val= map.getOrDefault(a,0);
            map.put(a,val+1);
        }

        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b) -> map.get(b)- map.get(a));
        pq.addAll(map.keySet());
        int[] res = new int[k];
        int i=0;
        while(i<k){
            res[i++]=pq.poll();
        }
        return res;
    }
}