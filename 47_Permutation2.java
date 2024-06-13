class Solution {
    List<List<Integer>> res=new ArrayList<>();
    HashSet<List<Integer>> listSet=new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] set= new boolean[nums.length];
        List<Integer> list= new ArrayList<>();
        Arrays.sort(nums);
        return permute(nums, set,list);   
    }
    
    public List<List<Integer>> permute(int[] nums, boolean[] set,List<Integer> list){
        if(list.size()==nums.length) {
            if(!listSet.contains(list)){
                listSet.add(new ArrayList<>(list));
                res.add(new ArrayList<>(list));
            }
            return res;
        }
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1] && !set[i-1]) continue;
            if(set[i]==false){
                set[i]=true;
                list.add(nums[i]);
                permute(nums,set,list);
                set[i]=false;
                list.remove(list.size()-1);
            }
        }
        return res;
    }
}