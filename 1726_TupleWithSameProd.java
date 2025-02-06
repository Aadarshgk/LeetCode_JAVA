import java.util.HashMap;
class Solution {
    public int tupleSameProduct(int[] nums) {
        int len=nums.length;
        if(len<4) return 0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                int prod=nums[i]*nums[j];
                map.put(prod,map.getOrDefault(prod,0)+1);
            }
        }

        int res=0;
        for(int prod: map.keySet()){
            int count=map.get(prod);
            if(count>1){
                res+= 8*(count*(count-1)/2);
            }
        }
        return res;
    }
}