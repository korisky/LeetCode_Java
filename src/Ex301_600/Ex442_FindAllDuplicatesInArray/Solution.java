package Ex301_600.Ex442_FindAllDuplicatesInArray;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    /**
     * 题目难点在于 -> 只能使用O(1)的额外空间, 且时间复杂度要在O(n)以内
     * 由于该题目说明了, 1 <= nums <= n, 并且每一个值只会出现1次或者2次, 在这个情况下, 我们可能进行一个+-的特殊算法
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 由于我们会设置其中值为负数, 为不影响这里使用abs取绝对值
            // 由于nums范围为1 -> n, 进行-1后得到的一定是下标的范围
            int checkIdx = Math.abs(nums[i]) - 1;
            if (nums[checkIdx] < 0) {
                // 我们遇到了这个值为负数, 证明之前已经遇到过, 那么进行记录
                result.add(nums[i]);
            }
            // 进行查询记录
            nums[checkIdx] = -nums[checkIdx];
        }
        return result;
    }
}
