import java.util.HashMap;
import java.util.HashSet;
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int count=0,res=0,len=0;
        HashSet<Integer> set=new HashSet<>();
        for(int n: nums){
            set.add(n);
            len++;
        }
        count=set.size();
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0,j=0;
        for(j=0;j<len;j++){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size()==count){
                res+=len-j;
                int num=nums[i++];
                int n=map.get(num);
                map.put(num,n-1);
                if(n==1){
                    map.remove(num);
                }
            }
        }

        return res;
    }
}