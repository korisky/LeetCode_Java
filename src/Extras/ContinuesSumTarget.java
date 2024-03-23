package Extras;

import java.util.LinkedList;
import java.util.List;

public class ContinuesSumTarget {

    /**
     * 给出target正整数, 找出至少2位数字构成的连续数组, 其sum刚好为target
     * 双指针进行判断
     */
    public static List<int[]> findContinuousSequence(int target) {

        List<int[]> result = new LinkedList<>();
        int left = 1, right = 1, sum = 0;

        // 遍历只需要到一半, 超过了也没有负数可以-回去, 但是这里一定是 =
        while (left <= target / 2) {
            if (sum < target) {
                // 当前sum不足, 需要延伸得到更大的值, 右指针向右
                sum += right++;
            } else if (sum > target) {
                // 当前sum超过, 需要减少值, 左指针向右
                sum -= left++;
            } else {
                // 当相同时, 进行记录
                int[] res = new int[right - left];
                for (int i = left; i < right; i++) {
                    res[i - left] = i;
                }
                result.add(res);
                // 并将左指针向右一位, sum减去这个
                sum -= left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<int[]> continuousSequence = findContinuousSequence(15);
        System.out.println();
    }
}
