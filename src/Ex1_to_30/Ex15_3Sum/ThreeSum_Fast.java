package Ex1_to_30.Ex15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;


public class ThreeSum_Fast {
    public List<List<Integer>> threeSum(int[] nums) {

        LinkedHashSet<List<Integer>> result = new LinkedHashSet<>();
        if (nums == null || nums.length < 3)
            return new ArrayList<>();

        int bigNegIndex = -1; // use negative number is better, we can figure out
        // if < 0, we don't have any pos / neg number
        int smallPosIndex = -1;
        int nLen = nums.length;
        Arrays.sort(nums);
        int maxVal = Math.abs(Math.max(-nums[0], nums[nLen - 1]));
        int[] freqArr = new int[2 * maxVal + 1];

        // 1. count frequency of each number we have,
        // also find biggest negative & smallest positive number
        // we store all number with their int val + maxVal (then don't need to care negative)
        for (int i = 0; i < nLen; i++) {
            int curNum = nums[i];
            freqArr[curNum + maxVal]++;
            if (curNum < 0)
                bigNegIndex = i;
            if (smallPosIndex < 0 && curNum > 0)
                smallPosIndex = i;
        }

        // 2.1 find whether we have three 0
        if (freqArr[0 + maxVal] >= 3)
            result.add(Arrays.asList(0, 0, 0));

        // 2.2 find situation that contains -n, 0, n
        // but we can just traverse from half of the whole arr (e.g only on positive side)
        if (freqArr[0 + maxVal] > 0 && smallPosIndex > 0) {
            for (int i = smallPosIndex; i < nLen; i++) {
                int curNum = nums[i]; // here it must be positive number
                if (freqArr[-curNum + maxVal] > 0) // if it's negative num exists, we find one
                    result.add(Arrays.asList(-curNum, 0, curNum));
            }
        }

        if (smallPosIndex >= 0 && bigNegIndex >= 0) {
            // 2.3.1 find situation that is : neg + pos + pos = 0
            // here can think about that "Left Right Bars" method
            for (int i = 0; i <= bigNegIndex; i++) {
                int curNeg = nums[i];
                int left = smallPosIndex;
                int right = nLen - 1;
                if (left == right)
                    break;
                if (curNeg + nums[left] + nums[left + 1] > 0)
                    continue; // if the smallest two > |curNeg|
                if (curNeg + nums[right - 1] + nums[right] < 0)
                    continue;
                while (left < right) {
                    int curPosL = nums[left];
                    int curPosR = nums[right];
                    if (curNeg + curPosL + curPosR > 0)
                        right--;
                    else if (curNeg + curPosL + curPosR < 0)
                        left++;
                    else {
                        result.add(Arrays.asList(curNeg, curPosL, curPosR));
                        right--;
                    }
                }
            }
            // 2.3.2 find situation that is : neg + neg + pos = 0
            for (int i = smallPosIndex; i < nLen; i++) {
                int curPos = nums[i];
                int left = 0;
                int right = bigNegIndex;
                if (left == right)
                    break;
                if (nums[left] + nums[left + 1] + curPos > 0)
                    continue; // |if the greatest(negative) two| < |curNeg|
                if (nums[right - 1] + nums[right] + curPos < 0)
                    continue;
                while (left < right) {
                    int curNegL = nums[left];
                    int curNegR = nums[right];
                    if (curNegL + curNegR + curPos > 0)
                        right--;
                    else if (curNegL + curNegR + curPos < 0)
                        left++;
                    else {
                        result.add(Arrays.asList(curNegL, curNegR, curPos));
                        left++;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        ThreeSum_Fast use = new ThreeSum_Fast();
        int[] test = new int[]{-1, 1, 0};
        System.out.println(use.threeSum(test));
    }
}
