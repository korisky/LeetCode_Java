package Ex1_to_30.Ex1_TwoSum;

// Given nums = [2, 7, 11, 15], target = 9,
// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].

import java.util.HashMap;

public class TwoSum_Fast {

    /*
    Instead of comparing them one by one,
    each time we meet a new number, we add a value (target - it's value)
    as key, and this number's index to the HashMap,

    Once we encounter a new number, we call containsKey method to check
    whether it is some other number's remaining value. It it is, it must be contain
    in the HashMap already.
     */

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> remains = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (remains.containsKey(nums[i])){
                return new int[]{remains.get(nums[i]), i};
            } else {
                remains.put(target - nums[i], i);
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        TwoSum_Fast use = new TwoSum_Fast();
        int[] test = new int[]{2, 7, 11, 15};
        int[] result = use.twoSum(test, 9);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
