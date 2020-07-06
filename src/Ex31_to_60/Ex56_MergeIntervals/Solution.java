package Ex31_to_60.Ex56_MergeIntervals;

/*
    Input: [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> store = new ArrayList<>();
        int curMin = Integer.MAX_VALUE;
        int curMax = Integer.MIN_VALUE;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int[] interval : intervals) {
            if (interval[0] <= curMax) {
                curMax = Math.max(curMax, interval[1]);
            } else {
                // add this
                store.add(new int[]{curMin, curMax});
                curMin = interval[0];
                curMax = interval[1];
            }
        }
        store.add(new int[]{curMin, curMax});
        store.remove(0);
        return store.toArray(new int[store.size()][]);
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        int[][] test = new int[2][];
        test[1] = new int[]{1, 3};
        test[0] = new int[]{3, 6};
//        test[2] = new int[]{8, 10};
//        test[3] = new int[]{15, 18};
        System.out.println(use.merge(test));
    }
}
