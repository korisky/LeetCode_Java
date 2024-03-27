package Ex601_900.Ex713_SubarrayProductLessThanK;

public class Solution {


    /**
     * 题目要求获取连续子序列, 使得其相乘数目 < k, 找到总共多少子序列可行
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1 || nums == null) return 0;

        // 使用双指针法, 维持一个slidingWindow
        int res = 0;
        int product = 1;
        for (int left = 0, right = 0; right < nums.length; right++) {

            // 先乘最新值
            product *= nums[right];

            // 如果乘上最新值使得超出, 进行除法, 左指针++
            while (product >= k) {
                product /= nums[left++];
            }

            // 算法核心, 这里意思是它的长度也代表了当前right到前面left之间, valid的部分大小
            // e.g. 当前是6,               < 370
            //      上一个就是 5, 6         < 370
            //      再往上  4,5,6          < 370
            //      一直掉 3,4,5,6         < 370
            // 这里的长度为4, 由于获取的是连续序列, 所以这里刚好跟4种方法相对应
            res += right - left + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
