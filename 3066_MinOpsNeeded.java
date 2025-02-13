import java.util.PriorityQueue;
class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int n: nums){
            pq.add((long)n);
        }
        int count=0;
        while(pq.peek()<k){
            long num1=pq.poll();
            long num2=pq.poll();
            pq.add(num1*2 + num2);
            count++;
        }
        return count;
    }
}