import java.util.HashMap;

class Solution {
    public static int subarraysWithSumK(int []a, int b) {
        // Write your code here
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,1);
        int xor=0;
        int count=0;
        for(int n: a){
            xor= (xor^n);
            if(map.containsKey(xor^b)){
                count+=map.get(xor^b);
            }

            map.put(xor,map.getOrDefault(xor, 0)+1);

        }
        return count;
    }
}