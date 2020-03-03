package Ex33_SearchInRotatedSortedArray;

/*
The main idea is about: a "fold" sorted array, only contains two parts: 1. increasing 2. decreasing
what we need to do is about figuring out whether this 'target' is in 1 or 2. then keep going by dichotomy
 */

public class search_S {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1)
            return -1;
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (end + start) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[start] <= nums[mid]) {
                // if currently start -> mid is an increasing sequence
                if (target >= nums[start] && target < nums[mid])
                    // target is inside this increasing sequence
                    end = mid - 1;
                else
                    // target must in decreasing sequence
                    start = mid + 1;
            } else {
                // currently mid -> end is an increasing sequence
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
