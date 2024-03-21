package Extras;

public class NoRepeatNum {

    public static void main(String[] args) {
        System.out.println(findEle(new int[]{1, 1, 2, 3, 5, 3, 2, 2}));
    }

    /**
     * 数组先递增后递减, 仅使用O(1)额外空间, 找到数组内不重复的元素个数
     */
    public static int findEle(int[] nums) {

        if (nums == null) {
            return 0;
        }

        // 1. 二分查找找到最大值的idx
        int peakIdx = findPeakIdx(nums);

        // 2. 左右指针聚合进行查找
        int left = Math.max(0, peakIdx - 1), right = Math.min(peakIdx + 1, nums.length - 1);
        while (left > 0 && nums[left] == nums[peakIdx]) {
            left--;
        }
        while (right < nums.length - 1 && nums[right] == nums[peakIdx]) {
            right++;
        }

        int unRepeat = 1;
        int leftPrev = nums[peakIdx], rightPrev = nums[peakIdx];
        while (left >= 0 && right <= nums.length - 1) {
            if (nums[left] == nums[right]) {
                // 两边相同, 都进行跳过
                left--;
                right++;
            } else if (nums[left] > nums[right]) {
                // 左边是更高的, 左指针继续向左
                if (nums[left] != leftPrev) {
                    // 只有与前一个值不同, 才算不同
                    leftPrev = nums[left];
                    unRepeat++;
                }
                left--;
            } else {
                // 右边值更高, 右指针向右
                if (nums[right] != rightPrev) {
                    rightPrev = nums[right];
                    unRepeat++;
                }
                right++;
            }
        }

        // 左指针或右指针仍未到达
        while (left >= 0) {
            if (leftPrev != nums[left]) {
                unRepeat++;
            }
            left--;
        }
        while (right <= nums.length - 1) {
            if (rightPrev != nums[right]) {
                unRepeat++;
            }
            right++;
        }

        return unRepeat;
    }

    /**
     * 二分法查找最高值的idx, 需要注意, 每次的mid应该是: start + (end - start)/2, 不是 (end - start)/2, 一定要加上start才对
     */
    public static int findPeakIdx(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
