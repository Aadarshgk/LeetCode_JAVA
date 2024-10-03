import java.util.HashMap;
class Solution {
    public int minSubarray(int[] nums, int p) {
        int len=nums.length;

        long prefixSum=0;

        for(int a: nums){
            prefixSum=(prefixSum + a)%p;
        }

        if(prefixSum==0) return 0; 
    
        HashMap<Long,Integer> map= new HashMap<>();
        map.put(0L,-1);

        long sum=0;
        int minLen=len;

        for(int i=0;i<len;i++){
            sum= (sum+nums[i])%p;
            long target= (sum-prefixSum+p)%p;

            if(map.containsKey(target)){
                minLen=Math.min(minLen, i-map.get(target));
            }

            map.put(sum,i);
        }

        return (minLen==len)?-1 : minLen;
    }
}