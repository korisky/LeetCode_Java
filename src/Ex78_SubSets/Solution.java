package Ex78_SubSets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        int setMaxSize = 1;
        while (setMaxSize <= nums.length) {
            helper(nums, 0, setMaxSize++, new ArrayList<>(), result);
        }
        result.add(new ArrayList<>()); // add empty set
        return result;
    }

    public void helper(int[] nums, int curIndex, int setMaxSize,
                       List<Integer> curComb, List<List<Integer>> result) {
        if (curComb.size() == setMaxSize)
            result.add(new ArrayList<>(curComb));
        else {
            for (int idx = curIndex; idx < nums.length; idx++) {
                curComb.add(nums[idx]);
                helper(nums, idx + 1, setMaxSize, curComb, result);
                curComb.remove(curComb.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        int[] test = new int[]{2, 3, 4};
        List<List<Integer>> res = use.subsets(test);
        for (List<Integer> list : res)
            System.out.println(list.toString());
    }
}
