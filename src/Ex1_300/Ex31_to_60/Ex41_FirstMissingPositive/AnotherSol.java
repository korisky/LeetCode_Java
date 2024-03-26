package Ex1_300.Ex31_to_60.Ex41_FirstMissingPositive;

public class AnotherSol {

    /**
     * 由于题目限制使用O(1)的空间复杂度, 考虑使用 CycleSort这个算法
     */
    public int firstMissingPositive(int[] nums) {

        // 1. CycleSort -> 尝试旋转的方式sort数组
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // nums[i] - 1 是应该在的位置, e.g. 2 -> [1, 2], 在 index = 1 的位置
            while (nums[i] > 0 // 只关注正数
                    && nums[i] <= n // 只关注当前值在nums长度范围内
                    && nums[nums[i] - 1] != nums[i]
                // nums[i] - 1 是这个数字应该在nums数组的正确位置(e.g. 3 -> idx:2),
                // 而nums[nums[i] - 1]相当于当前那一个位置, 放的值是不是目标的值
            ) {
                // 进行swap, swap结束后, nums[i]值就不同了, 由于是while, 所以会一直到结束条件为止
                swap(nums, nums[i] - 1, i);
            }
        }

        // 2. sort完毕, 找到位置不对的那个
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }

        // 如果位置都对, 那么返回下一个最大的
        return n + 1;
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        AnotherSol use = new AnotherSol();
        int[] test = new int[]{1, 3, 0, 2};
        System.out.println(use.firstMissingPositive(test));
    }
}
