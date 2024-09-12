import java.util.PriorityQueue;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q=new PriorityQueue<>((a,b) -> a-b);
        for(int a: nums){
            q.add(a);
            if(q.size()>k){
                q.remove();
            }
        }
        return q.remove();
    }
}