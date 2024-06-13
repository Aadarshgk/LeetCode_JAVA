import java.util.List;
import java.util.ArrayList;


class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] set = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        return permute(nums, set, list);
    }

    public List<List<Integer>> permute(int[] nums, boolean[] set, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set[i] == false) {
                set[i] = true;
                list.add(nums[i]);
                permute(nums, set, list);
                set[i] = false;
                list.remove(list.size() - 1);
            }
        }
        return res;
    }
}