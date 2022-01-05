package Ex287_FindDuplicateNumber;

/**
 * 需要找出数组中出现的重复元素, 并且规定了数字[1,n], 且只有一个元素进行了重复, 并且不提供额外的space,
 * 这里可以考虑使用快慢指针的思想, 最后他们一定会分别指向不同slot但是
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // detect the cycle, go one more step to start from the head
        // then we can find where is the loop begin
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
