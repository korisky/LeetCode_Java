package Ex2962_CountSubarraysWhereMaxElementAppearsLeastKTimes;

import java.util.Arrays;

/**
 * Input: nums = [1,3,2,3,3], k = 2
 * Output: 6
 * Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
 */
public class Solution {


    /**
     * 题目要求计算, 包含最大元素至少k次的情况的数组, 有多少种, 标准解答中使用slicingWindow: (与Ex2958有相似)
     * 1) 从左到右遍历, 统计遇到元素的频率
     * 2) 一旦遇到某个元素 == k频次, 一个可见连续的permutation就是, 从0到第一次这个频次出现元素的距离, 就是连续子字符串的次数
     * e.g 0, 1, 2,  3, 4,  5,  6
     * [4, 3, 7, 10, 2, 10, 10]       -> k=3时, 符合要求的字符串就是:  [0-6], [1-6], [2-6], [3-6]
     * 0, 1, 2,  3, 4,  5,  6， 7
     * [4, 3, 7, 10, 2, 10, 10, 5]    -> 如果我们向右搜索, 右移后符合要求但不与前面重复字符串就是:  [0-7], [1-7], [2-7], [3-7]
     * <p>
     * 可以看出来, 如果我们持续维持start和end, 那么每次更新end, 然后频次不变的情况下, 每次都是添加 (第一次遇到10的idx - startIdx) 这么多次
     * <p>
     * 而当我们遇到更多频次时, 需要考虑的是右移左边的start
     * 0, 1, 2,  3, 4,  5,  6， 7,  8
     * [4, 3, 7, 10, 2, 10, 10, 5, 10] -> 这个时候我们要尝试start向右移动到上一个10的位置(5), 这里的次数也从 0-3 4种,
     * [0-8], [1-8], [2-8], [3-8], [4-8], [5-8], 升级为 0-5 6种
     */
    public static long countSubarrays(int[] nums, int k) {

        if (nums == null) return 0;

        // 找到最大元素, 它出现的地方也就是需要考究可能出现符合要求字符串的地方
        int maxEle = Arrays.stream(nums).max().getAsInt();

        int start = 0, maxEleFreq = 0;
        long res = 0;
        for (int end = 0; end < nums.length; end++) {
            // 记录出现频次
            if (nums[end] == maxEle) {
                maxEleFreq++;
            }
            // 一旦出现频次符合, 进行计算与叠加
            while (maxEleFreq == k) {
                if (nums[start] == maxEle) {
                    maxEleFreq--;
                }
                start++;
            }
            // 这里就是所谓的, 统计可能的次数
            res += start;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));
    }
}
