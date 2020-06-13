package Ex90_SubSetII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public void helper(int[] nums, int curIndex,
                       List<Integer> curComb, List<List<Integer>> res) {
        if (curIndex <= nums.length)
            res.add(new ArrayList<>(curComb));
        int idx = curIndex;
        while (idx < nums.length) {
            curComb.add(nums[idx]);
            helper(nums, idx + 1, curComb, res);
            curComb.remove(curComb.size() - 1);
            idx++;
            while (idx < nums.length && nums[idx] == nums[idx - 1])
                idx++;
        }
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        int[] test = new int[]{1, 2, 2};
        List<List<Integer>> res = use.subsetsWithDup(test);
        for (List<Integer> list : res)
            System.out.println(list.toString());
    }
}
