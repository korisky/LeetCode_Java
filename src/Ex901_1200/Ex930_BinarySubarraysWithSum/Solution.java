package Ex901_1200.Ex930_BinarySubarraysWithSum;

public class Solution {
    public static int numSubarraysWithSum_Hash(int[] nums, int goal) {

        int pSum = 0, res = 0;
        int count[] = new int[nums.length + 1];
        count[0] = 1;

        for (int num : nums) {
            pSum += num;
            if (pSum >= goal) {
                res += count[pSum - goal];
            }
            count[pSum]++;
        }
        return res;
    }

    public static int numSubarraysWithSumSlicingWindow(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    public static int atMost(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }
        int res = 0, i = 0;
        for (int j = 0; j < nums.length; j++) {
            goal -= nums[j];
            while (goal < 0) {
                goal += nums[j++];
            }
            res += j - i + 1;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] test = new int[]{1, 0, 1, 0, 1};
        System.out.println(numSubarraysWithSumSlicingWindow(test, 2));
    }
}
