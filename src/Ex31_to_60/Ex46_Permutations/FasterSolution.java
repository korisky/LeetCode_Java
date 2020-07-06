package Ex31_to_60.Ex46_Permutations;

import java.util.ArrayList;
import java.util.List;

/*
    The faster implementation is quite similar to my own solution,
    main difference is on : when I use Arrays.stream(int[]).boxed().collect(Collectors.toList())
    can be replaced by : for loop and become much more faster
 */


public class FasterSolution {
    public List<List<Integer>> permute(int[] nums) {
        // inputs are distinct integers, do not need to count the frequency
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        List<List<Integer>> results = new ArrayList<>();
        getPermutes(nums, 0, results);
        return results;
    }

    public void getPermutes(int[] nums, int pointer, List<List<Integer>> results) {
        if (pointer == nums.length - 1) {
            ArrayList<Integer> curPer = new ArrayList<>();
            for (int i : nums)
                curPer.add(i);
            results.add(curPer);
        } else {
            for (int i = pointer; i < nums.length; i++) {
                swap(nums, pointer, i);
                getPermutes(nums, pointer + 1, results);
                swap(nums, pointer, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
