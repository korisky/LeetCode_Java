package Ex301_600.Ex331_to_360.Ex349_IntersectionTwoArrays;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目有合理的范围, 0 -> 1000, 所以可以简单使用定长的频率统计
 */
public class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {

        int[] nums1Freq = new int[1001];
        for (int num : nums1) {
            nums1Freq[num]++;
        }

        Set<Integer> resultList = new HashSet<>();
        for (int num : nums2) {
            if (nums1Freq[num] > 0) {
                nums1Freq[num]--;
                resultList.add(num);
            }
        }

        return resultList.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] intersection = intersection(nums1, nums2);
        for (int i : intersection) {
            System.out.print(i + " ");
        }

    }


}
