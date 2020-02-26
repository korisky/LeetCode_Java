package Ex15_3Sum;

import java.lang.reflect.Array;
import java.util.*;

/*
The self-implement of the fastest method.
Key point: -neg/2 as a pointer, we fixed this neg and keep traverse possible PosNum from this pointer,
 */

/*
IMPs:   1.1 if curNegVal <= looking <= curPosVal, it's really easy to understand
        1.2 but in: looking > curPosVal, it means we need to find bigger PosNum, cause we traverse Pos increasingly,
        we just 'continue' the loop would be all good.
        1.3 but in: looking < curNegVal: we have -curPosVal -curNegVal < curNegVal, which is curPosVal > 2*curNegVal,
        the we can 'break', because we traverse PosNum increasingly, we can't find smaller PosNum.
        2. we reduce repeated nums in PosNums and NegNums, then don't even need LinkedHashSet.
        3. we can sort the list on the part we care: Arrays.sort(list, start, end)
 */

public class ThreeSum_Fastest_Simulating {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return new ArrayList<>();

        Arrays.sort(nums); // O(nLogn)
        int maxVal = Math.abs(Math.max(-nums[0], nums[nums.length - 1]));
        int zeroNums = 0;
        int posLen = 0;
        int negLen = 0;

        for (int n : nums) { // O(n)
            if (n > 0)
                posLen++;
            else if (n < 0)
                negLen++;
            else
                zeroNums++;
        }

        if (zeroNums >= 3)
            result.add(Arrays.asList(0, 0, 0));
        if (posLen == 0 || negLen == 0)
            return result;

        int[] freqArr = new int[2 * maxVal + 1];
        int[] posNums = new int[posLen];
        int[] negNums = new int[negLen];
        posLen = 0;
        negLen = 0;
        for (int n : nums) { // O(n)
            if (freqArr[maxVal + n]++ == 0){
                if (n > 0)
                    posNums[posLen++] = n;
                else if (n < 0)
                    negNums[negLen++] = n;
            }
        }
        Arrays.sort(posNums, 0, posLen); // O(nlogn)
        Arrays.sort(negNums, 0, negLen);

        int bigEnPosIn = 0;
        for (int ng_idex = negLen - 1; ng_idex >= 0; ng_idex--) { // O(n/2)
            int curNegVal = negNums[ng_idex];
            int minPos = (-curNegVal) >>> 1;
            while (bigEnPosIn < posLen && posNums[bigEnPosIn] < minPos) {
                bigEnPosIn++;
            }
            for (int pos_idex = bigEnPosIn; pos_idex < posLen; pos_idex++) { //O(n/2)
                int curPosVal = posNums[pos_idex];
                int looking = -curPosVal - curNegVal;
                if (looking >= curNegVal && looking <= curPosVal) {
                    if (looking == curNegVal) {
                        if (freqArr[curNegVal + maxVal] > 1)
                            result.add(Arrays.asList(curNegVal, curNegVal, curPosVal));
                    } else if (looking == curPosVal) {
                        if (freqArr[curPosVal + maxVal] > 1)
                            result.add(Arrays.asList(curNegVal, curPosVal, curPosVal));
                    } else if (freqArr[looking + maxVal] > 0) {
                        result.add(Arrays.asList(curNegVal, looking, curPosVal));
                    }
                } else if (looking < curNegVal){
                    break;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum_Fastest_Simulating use = new ThreeSum_Fastest_Simulating();
        int[] test = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println(use.threeSum(test));
    }
}
