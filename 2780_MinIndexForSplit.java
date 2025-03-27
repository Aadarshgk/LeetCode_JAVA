import java.util.List;
import java.util.HashMap;
class Solution {
    public int minimumIndex(List<Integer> nums) {
        int len=nums.size();
        HashMap<Integer,Integer> map=new HashMap<>();
        int dom=0,count=0;
        for(int n:nums){
            int temp=map.getOrDefault(n,0);
            if(temp+1 > count){
                dom=n;
                count=temp+1;
            }
            map.put(n,temp+1);
        }
        int left=0;
        for(int i=0;i<len-1;i++){
            if(nums.get(i)==dom) left++;
            int right=count-left;

            if(left>(i+1)/2 && right> (len-1-i)/2){
                return i;
            }
        }

        return -1;
    }
}