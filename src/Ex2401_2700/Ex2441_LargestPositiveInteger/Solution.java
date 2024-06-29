package Ex2401_2700.Ex2441_LargestPositiveInteger;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int findMaxK(int[] nums) {
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                max = Math.max(max, Math.max(num, -num));
            }
            set.add(-num);
        }
        return max > 0 ? max : -1;
    }

    public static void main(String[] args) {
        System.out.println(findMaxK(new int[]{-1, 2, -3, 3}));
    }
}
