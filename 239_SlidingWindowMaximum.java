import java.util.PriorityQueue;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len=nums.length;
        int[] res= new int[len-k+1];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<k-1;i++){
            pq.add(new int[]{nums[i],i});
        }

        for(int i=k-1;i<len;i++){
            pq.add(new int[]{nums[i],i});
            int[] ar=pq.peek();
            while(!pq.isEmpty() && ar[1]<=i-k){
                pq.poll();
                ar=pq.peek();
            }
            res[i-k+1]=ar[0];
        }

        return res;
    }
}