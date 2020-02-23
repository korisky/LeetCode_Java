package Ex1_TwoSum;

//Given nums = [2, 7, 11, 15], target = 9,
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].

import java.util.HashMap;

public class TwoSum_Fast {
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
