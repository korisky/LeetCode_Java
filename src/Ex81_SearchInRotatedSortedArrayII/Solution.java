package Ex81_SearchInRotatedSortedArrayII;

/*
    The difference between the Search In Rotated Sorted Array I is:
        we need to handle the situation of nums[start] == nums[mid]
        how? just make start ++ and do nothing!

    Main idea: we need to compare nums[start]'s and nums[mid]'s value,
    and figure out the rotated part is on left or right. Then we can
    focusing on the monotonous part and judge whether our target is within
    that monotonous part or not.
 */

public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length < 1)
            return false;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid])
                return true;
            if (nums[start] == nums[mid]) {
                start++;
            } else if (nums[start] < nums[mid]) { // start -> mid must increasing
                if (nums[start] <= target && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                // rotated part on left
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        int[] test = new int[]{3, 1, 2, 2, 2};
        System.out.println(use.search(test, 2));
    }
}
