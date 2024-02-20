package Ex151_to_180.Ex154_FindMinimumRotatedSortedArrayII;

/**
 * 与153最大区别在于, 由于现在不是特殊的升序, 可能存在升序, 所以当left, right, mid都相等时, 并不能知道最小元素属于哪个区间
 * 这个时候只能使用right--这样来试图缩小搜素范围
 * 不使用额外的mid, 会更好, 后续当startIdx == endIdx即可跳出循环, 防止遗漏个别index
 */
public class Solution {

    public int findMin(int[] nums) {
        int startIdx = 0;
        int endIdx = nums.length - 1;
        while (startIdx < endIdx) {
            int midIdx = (startIdx + endIdx) / 2;
            if (nums[midIdx] < nums[endIdx]) {
                endIdx = midIdx;
            } else if (nums[midIdx] > nums[endIdx]) {
                startIdx = midIdx + 1;
            } else {
                endIdx--;
            }
        }
        // when startIdx == endIdx, thus, nums[startIdx] == nums[endIdx]
        return nums[endIdx];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test1 = new int[]{10,11,1,10,10,10,11};
        int[] test2 = new int[]{3,3,1,3};
        int[] test3 = new int[]{2,2,2,0,1};
        int[] test4 = new int[]{10,1,10,10,10};
        System.out.println(s.findMin(test1));
        System.out.println(s.findMin(test2));
        System.out.println(s.findMin(test3));
        System.out.println(s.findMin(test4));
    }
}
