import java.util.PriorityQueue;
class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        int len= queries.length;
        int[] res= new int[len];
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)-> b-a);
        for(int i=0;i<len;i++){
            int val= Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            pq.add(val);
            if(pq.size()>k){
                pq.poll();
            }
            if(pq.size()<k){
                res[i]=-1;
            }else{
                res[i]=pq.peek();
            }
        }   
        return res;
    }
}