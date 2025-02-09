import java.util.HashMap;
class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int len=nums.length;
        long total=0,good=0;
        for(int i=0;i<len;i++){
            int prev=map.getOrDefault(nums[i]-i,0);
            good+=prev;
            map.put(nums[i]-i, prev+1);
        }

        total = (long)len*(len-1)/2;
        return total-good;
    }
}