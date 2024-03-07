package Ex1_300.Ex61_to_90.Ex78_SubSets;

import java.util.ArrayList;
import java.util.List;

/*
    The difference between the slower solution, int this faster solution
    we do not need to take care of the current set's size.

    Because, if we track the trace, we can find out, e.g. {2, 3, 4}
    our trace in the recursion would be: {null, 2, 23, 234, 3, 34, 4}
    that would be what we need!
 */

public class FasterSolution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public void helper(int[] nums, int curIndex,
                       List<Integer> curComb, List<List<Integer>> res) {
        res.add(new ArrayList<>(curComb));
        for (int idx = curIndex; idx < nums.length; idx++) {
            curComb.add(nums[idx]);
            helper(nums, idx + 1, curComb, res);
            curComb.remove(curComb.size() - 1);
        }
    }

    public static void main(String[] args) {
        FasterSolution use = new FasterSolution();
        int[] test = new int[]{2, 3, 4};
        List<List<Integer>> res = use.subsets(test);
        for (List<Integer> list : res)
            System.out.println(list.toString());
    }
}
