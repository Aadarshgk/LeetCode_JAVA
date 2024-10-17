import java.util.PriorityQueue;
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((x,y) -> y[1]-x[1]);
        StringBuilder sb= new StringBuilder();
        if(a>0) pq.add(new int[]{'a',a});
        if(b>0) pq.add(new int[]{'b',b});
        if(c>0) pq.add(new int[]{'c',c});

        while(!pq.isEmpty()){
            int[] ar1= pq.poll();
            if(sb.length()>1 && sb.charAt(sb.length()-1)==ar1[0] && sb.charAt(sb.length()-2)==ar1[0]){
                if(pq.isEmpty()) break;

                int[] ar2=pq.poll();
                sb.append((char)ar2[0]);
                if(--ar2[1]>0){
                    pq.offer(ar2);
                }
            }else{
                sb.append((char)ar1[0]);
                ar1[1]--;
            }

            if(ar1[1]>0) pq.offer(ar1);
        }

        return sb.toString();
    }
}