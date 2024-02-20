package Ex151_to_180.Ex179_LargestNumber;

import java.util.*;

/**
 * 问题重点在于, 实际上可以将比较缩小为两个str的比较, 这样只需要重写一个Comparater, 然后用Arrays.sort即可完成负责目标
 */
public class Solution {

    public String largestNumber(int[] nums) {

        if (null == nums || nums.length == 0) {
            return "";
        }

        String[] numArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numArr[i] = String.valueOf(nums[i]);
        }

        // 重点在于, 将两个数字进行比较即可
        Arrays.sort(numArr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        // 针对0开头的, 即使多个全0, 也应该返回0
        if (numArr[0].charAt(0) == '0') {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : numArr) {
            sb.append(s);
        }
        return sb.toString();
    }


}
