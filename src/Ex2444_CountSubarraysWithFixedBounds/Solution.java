package Ex2444_CountSubarraysWithFixedBounds;

public class Solution {


    /**
     * 来自Lee215的最优解
     */
    public static long countSubarrays(int[] nums, int minK, int maxK) {

        // 初始化内容, 其中jBad就是小于最小值, 或者超出最大值的, 从左到右遍历时遇到的
        // 而jMin和jMax持续维持当前满足最大最小值条件的位置, 遇到第二个才会进行更新
        // 所以持续从左到右的遍历中, 获取符合条件的字符串的数目, 需要考虑min和max中的更小的一个的位置
        long res = 0, jbad = -1, jmin = -1, jmax = -1, n = nums.length;
        for (int i = 0; i < n; ++i) {
            // 持续更新超出范围的index位置
            if (nums[i] < minK || nums[i] > maxK) {
                jbad = i;
            }
            if (nums[i] == minK) {
                jmin = i;
            }
            if (nums[i] == maxK) {
                jmax = i;
            }
            // 核心在于, 符合的字符串数目就是位置的差值, 而每次我们都进行更新, 以min和max更小的一个为位置
            // 减去刚好超出范围的index, 并且持续找到超出范围的jBad
            res += Math.max(0L, Math.min(jmin, jmax) - jbad);
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(countSubarrays(new int[]{1, 2, 3, 4, 5}, 1, 5));
        System.out.println(countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5));
    }
}
