import java.util.HashMap;
class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer,Integer> map=new HashMap<>();
        HashMap<Integer,Integer> ball=new HashMap<>();
        int[] res=new int[queries.length];
        int i=0;
        for(int[] query: queries){
            int b=query[0];
            int col=query[1];

            int prev=ball.getOrDefault(b,0);
            if(prev!=0){
                if(map.get(prev)==1){
                    map.remove(prev);
                }else{
                    map.put(prev,map.get(prev)-1);
                }
            }

            ball.put(b,col);
            map.put(col,map.getOrDefault(col,0)+1);
            res[i++]=map.size();
        }
        return res;
    }
}