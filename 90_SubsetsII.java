class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);
        subsets(res,new ArrayList<>(),nums,0);
        return res;   
    }

    public void subsets(List<List<Integer>> res, List<Integer> temp, int[] nums, int id){
        if(id==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[id]);
        subsets(res,temp,nums,id+1);
        temp.remove(temp.size()-1);

        while(id<nums.length-1 && nums[id]==nums[id+1]){
            id++;
        }         
        subsets(res,temp,nums,id+1);
    }
}