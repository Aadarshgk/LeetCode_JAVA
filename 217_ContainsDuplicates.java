class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> set=new HashMap<>();
        for(int n: nums){
            if(set.containsKey(n)){
                return true;
            }
            set.put(n,1);
        }
        return false;
    }
}