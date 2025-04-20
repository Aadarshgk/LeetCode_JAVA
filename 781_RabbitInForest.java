import java.util.HashMap;
class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n: answers){
            map.put(n+1,map.getOrDefault(n+1,0)+1);
        }
        int res=0;
        for(int n: map.keySet()){
            int count=map.get(n);
            res+=(count/n) * n;
            if(count%n!=0){
                res+=n;
            }
        }
        return res;
    }
}