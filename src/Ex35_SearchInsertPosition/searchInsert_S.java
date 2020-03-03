package Ex35_SearchInsertPosition;

/*
If we wanna find EXACT NUMBER, we can set start = mid - 1 || end = mid + 1
But, once we just wanna comparing, we must : start = mid, end = mid
 */

public class searchInsert_S {
    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0])
            return 0;
        if (target > nums[nums.length - 1])
            return nums.length;
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (end - start < 2) {
                if (nums[start] == target)
                    return start;
                else
                    return end;
            }
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid;
            else
                start = mid;
        }
        return 0;
    }

    public static void main(String[] args) {
        searchInsert_S use = new searchInsert_S();
        int[] test_1 = new int[]{1, 3};
        System.out.println(use.searchInsert(test_1, 3));
    }
}
