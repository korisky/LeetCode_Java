package Ex350_IntersectionTwoArraysII;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{2, 3, 4, 5, 6};
        int[] intersect = intersect(nums1, nums2);
        for (int i : intersect) {
            System.out.print(i + " ");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        // 先排序, 方便遍历, O(2 x NlogN) -> O(NlogN)
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> intersectList = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                intersectList.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return intersectList.stream().mapToInt(theInt -> theInt).toArray();
    }


    /**
     * 这个方法思路对的, 但是遇到有重复元素就不行了
     */
    public static int[] intersect_NotAccept(int[] nums1, int[] nums2) {

        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> anotherSet1 = new HashSet<>(set1);

        // e.g. {1, 2, 3} - {2, 4, 6} = {1, 3}
        set1.removeAll(set2);
        // e.g. {1, 2, 3} - {1, 3} = {2}
        anotherSet1.removeAll(set1);

        return anotherSet1.stream().mapToInt(theInt -> theInt).toArray();
    }
}
