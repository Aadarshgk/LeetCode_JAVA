import java.util.PriorityQueue;
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int len=costs.length-1;
        PriorityQueue<Integer> p1=new PriorityQueue<>((x,y)-> x-y);
        PriorityQueue<Integer> p2=new PriorityQueue<>((x,y)-> x-y);
        int i=0,j=len;
        long res=0;

        while(k>0){
            while(p1.size()<candidates && i<=j){
                p1.add(costs[i++]);
            }

            while(p2.size()<candidates && j>=i){
                p2.add(costs[j--]);
            }

            int peek1=Integer.MAX_VALUE,peek2=Integer.MAX_VALUE;
            if(!p1.isEmpty()){
                peek1= p1.peek();
            }
            
            if(!p2.isEmpty()){
                peek2= p2.peek();
            } 

            if(peek1<=peek2){
                res+=peek1;
                p1.remove();
            }else{
                res+=peek2;
                p2.remove();
            }

            k--;
        }

        return res;
    }
}