package Ex15_3Sum;

import java.util.*;

/*
slower than the one with left & right bar in original Fast
 */

public class ThreeSum_Fastest_In_Python {
    public List<List<Integer>> threeSum(int[] nums) {

        LinkedHashSet<List<Integer>> result = new LinkedHashSet<>();
        if (nums == null || nums.length < 3)
            return new ArrayList<>();

        Arrays.sort(nums);
        int maxVal = Math.abs(Math.max(-nums[0], nums[nums.length - 1]));

        int[] freqArr = new int[2 * maxVal + 1];
        List<Integer> negNums = new ArrayList<>();
        List<Integer> posNums = new ArrayList<>();
        int zeroNums = 0;

        for (int n : nums) {
            if (n > 0){
                posNums.add(n);
            }
            else if (n < 0)
                negNums.add(n);
            else
                zeroNums++;
            freqArr[maxVal + n]++;
        }

        if (zeroNums >= 3)
            result.add(Arrays.asList(0, 0, 0));

        for (int pos : posNums) {
            if (pos == 0)
                continue;
            for (int neg : negNums) {
                if (neg == 0)
                    continue;
                int looking = -pos - neg; // a+b+c = 0, c = -a - b
                if (freqArr[looking + maxVal] == 0) // if we don't even have this need val
                    continue;
                if (looking == 0 && zeroNums > 0)
                    result.add(Arrays.asList(neg, 0, pos));
                else if (looking == pos && freqArr[pos + maxVal] > 1) // use pos twice
                    result.add(Arrays.asList(neg, pos, pos));
                else if (looking == neg && freqArr[neg + maxVal] > 1) // use neg twice
                    result.add(Arrays.asList(neg, neg, pos));
                else if (looking > pos && freqArr[looking + maxVal] > 0)
                    result.add(Arrays.asList(neg, pos, looking));
                else if (looking < neg && freqArr[looking + maxVal] > 0)
                    result.add(Arrays.asList(looking, neg, pos));
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        ThreeSum_Fastest_In_Python use = new ThreeSum_Fastest_In_Python();
        int[] test = new int[]{-1, 1, 0, 2, 5, -4};
        System.out.println(use.threeSum(test));
    }
}
