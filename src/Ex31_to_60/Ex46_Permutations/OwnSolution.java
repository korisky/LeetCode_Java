package Ex31_to_60.Ex46_Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OwnSolution {
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
            results.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        } else {
            for (int i = pointer; i < nums.length; i++) {
                // let i = pointer, then we can also get the 'origin' permutation
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


    public static void main(String[] args) {
        OwnSolution use = new OwnSolution();
        System.out.println(use.permute(new int[]{1, 2, 3}));
    }
}
