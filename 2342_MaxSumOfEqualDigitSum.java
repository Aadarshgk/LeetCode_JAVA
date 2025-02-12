import java.util.HashMap;
class Solution {
    public int maximumSum(int[] nums) {
        int max=-1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n: nums){
            int sum=0;
            int temp=n;
            while(temp>0){
                sum+=(temp%10);
                temp/=10;
            }

            if(map.containsKey(sum)){
                int m=map.get(sum);
                max=Math.max(max,n+m);
                map.put(sum,(n>m)?n:m);
            }else{
                map.put(sum,n);
            }
        }
        return max;
    }

}