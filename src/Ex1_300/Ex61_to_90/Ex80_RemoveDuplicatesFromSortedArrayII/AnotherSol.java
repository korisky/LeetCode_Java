package Ex1_300.Ex61_to_90.Ex80_RemoveDuplicatesFromSortedArrayII;

public class AnotherSol {

    /**
     * 由于题目说明nums是非递减的序列, 所以可以不用统计freq或者map都可以实现
     */
    public int removeDuplicates(int[] nums) {

        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            // 更新count
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            // 针对count进行移动
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

}
