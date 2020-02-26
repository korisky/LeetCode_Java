package Ex15_3Sum;

import java.util.*;

/*
Generally, this program's method is similar to the 'fast' + 'fastest in python' combination,
But, it use a much quickly stuff:
each time, we traverse from decreasing order in NegNums and increasing order in PosNums.
Further more, in the loop of NegNums, before it call PosNum's loop, it would do : Math.abs(neg)/2
which means: we only looking the Positive nums, that is at least greater than |neg/2| Also, afterthat
we keep updating this stating point, because we traverse the NegNums in decreasing order, only bigger
PosNums can be using.
 */

public class ThreeSum_Fastest {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int negSize = 0;
        int posSize = 0;
        int zeroSize = 0;
        for (int v : nums) {
            if (v < minValue)
                minValue = v;
            if (v > maxValue)
                maxValue = v;
            if (v > 0)
                posSize++;
            else if (v < 0)
                negSize++;
            else
                zeroSize++;
        }
        if (zeroSize >= 3)
            res.add(Arrays.asList(0, 0, 0));
        if (negSize == 0 || posSize == 0)
            return res;
        if (minValue * 2 + maxValue > 0)
            maxValue = -minValue * 2;     // ?????????????????????????
        else if (maxValue * 2 + minValue < 0)
            minValue = -maxValue * 2;

        // value counter
        int[] map = new int[maxValue - minValue + 1]; // ??????????????????
        int[] negs = new int[negSize];
        int[] poses = new int[posSize];
        negSize = 0;
        posSize = 0;
        for (int v : nums) {
            if (v >= minValue && v <= maxValue) {
                if (map[v - minValue]++ == 0) { // first time we meet this value,
                                                    // we add 1 to it and add it to pos / neg arr
                    if (v > 0)
                        poses[posSize++] = v;
                    else if (v < 0)
                        negs[negSize++] = v;
                }
            }
        }
        Arrays.sort(poses, 0, posSize);
        Arrays.sort(negs, 0, negSize);
        int basej = 0;
        for (int i = negSize - 1; i >= 0; i--) {
            int nv = negs[i];
            int minp = (-nv) >>> 1; // get it's binary num and move 1 digit without sign
            while (basej < posSize && poses[basej] < minp)
                basej++;
            for (int j = basej; j < posSize; j++) {
                int pv = poses[j];
                int cv = 0 - nv - pv;
                if (cv >= nv && cv <= pv) {
                    if (cv == nv) {
                        if (map[nv - minValue] > 1)
                            res.add(Arrays.asList(nv, nv, pv));
                    } else if (cv == pv) {
                        if (map[pv - minValue] > 1)
                            res.add(Arrays.asList(nv, pv, pv));
                    } else {
                        if (map[cv - minValue] > 0)
                            res.add(Arrays.asList(nv, cv, pv));
                    }
                } else if (cv < nv)
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum_Fastest use = new ThreeSum_Fastest();
        int[] test = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println(use.threeSum(test));
    }
}
