import java.util.HashSet;
class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int n: nums){
            if(n<k) return -1;
            set.add(n);
        }
        int len=set.size();
        return (set.contains(k))?len-1: len;
    }
}