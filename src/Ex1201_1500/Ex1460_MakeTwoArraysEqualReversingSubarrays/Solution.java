package Ex1201_1500.Ex1460_MakeTwoArraysEqualReversingSubarrays;

public class Solution {

    /**
     * 题目需要我们判断两个arr是否可以通过内部reverse的方式得到,
     * 实际上如果长度相同, 内包含元素的次数也相同, 那么一定可以扭转成功的
     */
    public static boolean canBeEqual(int[] target, int[] arr) {
        int[] freqMap = new int[1001];
        for (int arrNum : arr) {
            freqMap[arrNum]++;
        }
        for (int targetNum : target) {
            if (freqMap[targetNum] <= 0) {
                return false;
            }
            freqMap[targetNum]--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
        System.out.println(canBeEqual(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}));
        System.out.println(canBeEqual(new int[]{1}, new int[]{1}));
        System.out.println(canBeEqual(new int[]{1, 3, 4}, new int[]{1, 7, 4}));
    }
}
