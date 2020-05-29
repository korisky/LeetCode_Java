package Ex377_CombinationSumIV;

/*
       The method is about: e.g. we need combination sum of 4, we can get :

       Comb[4] = Comb[4 - 1] + Comb[4 - 2] + Comb[4 - 3] = Comb[3] + Comb[2] + Comb[1] + 0

       If we need all combinations sum to 4, that means we need to find out all combination of 3, 2, and 1.
       This can be explained as: if we need a small number to reach the Target, that number still need to be
       one of the number in the array.

       For a single time we add elements that sum to target, we have so many INTERNAL SUM,
       which can sum to 1, 2, 3, 4. If we STORE these times that a single time we reach to
       a specific number (1, 2, 3, 4). Next time we find, oh we only need a value e.g. 3
       to reach 4, then we can just add the number of times we calculated before, then that's
       the real time.
 */

import java.util.Arrays;

public class FasterSolution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] store = new int[target + 1];
        Arrays.fill(store, -1); // set -1 means we never reach this target number
        store[0] = 1; // set 0 to 1 means at least we need to reach target with one single combination
        return helper(nums, target, store);
    }

    private int helper(int[] nums, int target, int[] store) {
        if (store[target] != -1) // means we reach this number before
            return store[target];

        int curTargetTimes = 0;
        for (int num : nums) {
            if (num <= target)
                curTargetTimes += helper(nums, target - num, store);
            else
                break;// we sort nums before, if current one is greater than target,
            // next must also greater than target
        }
        store[target] = curTargetTimes;
        return curTargetTimes;
    }


    public static void main(String[] args) {
        FasterSolution use = new FasterSolution();
        System.out.println(use.combinationSum4(new int[]{2, 1, 3}, 35));
    }
}
