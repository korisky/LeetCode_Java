package Ex35_SearchInsertPosition;

/*
If we wanna find EXACT NUMBER, we can set start = mid - 1 || end = mid + 1
But, once we just wanna comparing, we must : start = mid, end = mid
 */

public class searchInsert_S_Easier {
    public int searchInsert(int[] nums, int target) {
        int indexLow = 0;
        int indexHigh = nums.length - 1;
        while (indexLow <= indexHigh) {
            int indexMid = (indexLow + indexHigh) / 2;
            if (target == nums[indexMid])
                return indexMid;
            else if (target < nums[indexMid])
                indexHigh = indexMid - 1;
            else
                indexLow = indexMid + 1;
        }
        return indexLow;
    }

    public static void main(String[] args) {
        searchInsert_S_Easier use = new searchInsert_S_Easier();
        int[] test_1 = new int[]{1, 3};
        System.out.println(use.searchInsert(test_1, 3));
    }
}
