import java.util.PriorityQueue;
class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
        for(int n: gifts){
            pq.add(n);
        }

        while(k>0 && !pq.isEmpty()){
            int n=pq.poll();
            n=(int)Math.sqrt(n);
            pq.add(n);
            k--;
        }

        long res=0;
        while(!pq.isEmpty()){
            res+=pq.poll();
        }

        return res;
    }
}