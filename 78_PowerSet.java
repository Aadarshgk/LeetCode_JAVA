class Solution {
    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        boolean[] set= new boolean[nums.length];
        List<Integer> list=new ArrayList<>();
        subsets(nums,0,list);
        return res;

    }

    public void subsets(int[] nums, int i, List<Integer> list){
        if(i==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        subsets(nums,i+1,list);
        list.add(nums[i]);
        subsets(nums,i+1,list);
        list.remove(list.size()-1);

    }

}