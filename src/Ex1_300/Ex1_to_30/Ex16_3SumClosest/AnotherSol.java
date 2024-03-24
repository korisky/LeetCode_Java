package Ex1_300.Ex1_to_30.Ex16_3SumClosest;

import java.util.Arrays;

public class AnotherSol {

    /**
     * 更直观简单的方法, 可能速度慢1ms, 时间复杂度 O(n^2)
     * 1. 首先进行排序, 让数组单调递增
     * 2. 3个指针, 固定left后, 动态修改mid和right指针
     * 3. left持续向右
     */
    public int threeSumClosest(int[] nums, int target) {

        // 先进行排序, 假设mergeSort, O(logN)
        Arrays.sort(nums);

        int minDif = Integer.MAX_VALUE;
        int thatSum = nums[0] + nums[1] + nums[2]; // 初始一下

        // 3指针, 左指针作为最小值不同, 右指针一直从右到左, 中间指针则是从左到右
        // 因为必须为3sum, 所以这里 < nums.length - 2 保证mid和right有值可取
        // 这里几乎是 O(n^2)
        for (int l = 0; l < nums.length - 2; l++) {
            int mid = l + 1;
            int r = nums.length - 1;
            int curTar = target - nums[l];
            while (mid < r) {
                int dif = curTar - nums[mid] - nums[r];
                if (minDif > Math.abs(dif)) {
                    minDif = Math.abs(dif);
                    thatSum = nums[l] + nums[mid] + nums[r];
                }
                if (dif > 0) {
                    // > 0, 需要更大的值, mid 向右
                    mid++;
                } else if (dif < 0) {
                    // > 0, 需要更小的值, r 向左
                    r--;
                } else {
                    // 刚好相等, 直接返回
                    break;
                }
            }
        }
        return thatSum;
    }

    public static void main(String[] args) {
        AnotherSol use = new AnotherSol();
//        System.out.println(use.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(use.threeSumClosest(new int[]{0, 1, 2}, 3));
    }
}
