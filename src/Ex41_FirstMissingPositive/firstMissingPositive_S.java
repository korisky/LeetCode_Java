package Ex41_FirstMissingPositive;

/*
As a RULE in this question, we can only use O(1) space,
Thus, we need to use this 'CYCLE SORT' , we only swap number to it's "should be" position.
 */

public class firstMissingPositive_S {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1); // here we must use an external function !!!!!!!!!!!!
            else
                i++;
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1)
                return j + 1;
        }
        return nums.length + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        firstMissingPositive_S use = new firstMissingPositive_S();
        int[] test = new int[]{1, 3, 0, 2};
        System.out.println(use.firstMissingPositive(test));
    }
}
