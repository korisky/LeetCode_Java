package Ex1801_2100.Ex2191_SortJumbledNumbers;

import java.util.*;

public class Solution {

    public static int[] sortJumbled(int[] mapping, int[] nums) {

        TreeMap<Integer, List<Integer>> mappedMap = new TreeMap<>();
        for (int num : nums) {
            int reversedNum = recursiveMapping(num, mapping);
            List<Integer> sameNumList = mappedMap.getOrDefault(reversedNum, new LinkedList<>());
            sameNumList.add(num);
            mappedMap.put(reversedNum, sameNumList);
        }

        int i = 0;
        int[] result = new int[nums.length];
        for (Map.Entry<Integer, List<Integer>> entry : mappedMap.entrySet()) {
            for (Integer num : entry.getValue()) {
                result[i++] = num;
            }
        }

        return result;
    }

    /**
     * Recursive + Integer 计算的方式, 对单个数字进行mapping
     */
    private static int recursiveMapping(int curNum, int[] mapping) {
        if (curNum < 10) {
            return mapping[curNum];
        }
        int lastDigit = mapping[curNum % 10];
        return recursiveMapping(curNum / 10, mapping) * 10 + lastDigit;
    }

    public static void main(String[] args) {
        // check single function
//        System.out.println(recursiveMapping(991, new int[]{8, 9, 4, 0, 2, 1, 3, 5, 7, 6}));
//        System.out.println(recursiveMapping(38, new int[]{8, 9, 4, 0, 2, 1, 3, 5, 7, 6}));
//        System.out.println(recursiveMapping(338, new int[]{8, 9, 4, 0, 2, 1, 3, 5, 7, 6}));
        // integration test
        int[] resultArr = sortJumbled(new int[]{8, 9, 4, 0, 2, 1, 3, 5, 7, 6}, new int[]{338, 38, 991});
        for (int i : resultArr) {
            System.out.println(i);
        }

    }
}
