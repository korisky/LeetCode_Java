package Ex167_TwoSumII;

/**
 * 与Ex1_TwoSum最大的不同, 由于此时的数组已经排序, 可以非常简单的使用左右两个指针向中间靠拢
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lIdx = 0;
        int rIdx = numbers.length - 1;
        while (numbers[lIdx] + numbers[rIdx] != target) {
            if (target > numbers[lIdx] + numbers[rIdx]) {
                lIdx++;
            } else {
                rIdx--;
            }
        }
        return new int[]{lIdx + 1, rIdx + 1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{2, 7, 11, 15};
        int[] ints = s.twoSum(test, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
