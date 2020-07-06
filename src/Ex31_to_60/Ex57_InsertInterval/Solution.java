package Ex31_to_60.Ex57_InsertInterval;

/*
    Example 1:

    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    Output: [[1,5],[6,9]]


    Example 2:

    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    Output: [[1,2],[3,10],[12,16]]
    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10]
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (newInterval == null)
            return intervals;
        if (intervals == null || intervals.length == 0)
            return new int[][]{newInterval};


        int overlapStart = newInterval[0];
        int overlapEnd = newInterval[1];

        // concat (enlarge) the overlaps
        for (int[] ints : intervals) {
            int curIntStart = ints[0];
            int curIntEnd = ints[1];
            if (curIntStart > overlapEnd)
                break; // the intervals are sorted, later must no overlap
            if (curIntEnd < overlapStart)
                continue; // this slot must has no overlap

            // then the slot must be over lap
            overlapStart = Math.min(overlapStart, curIntStart);
            overlapEnd = Math.max(overlapEnd, curIntEnd);
        }

        // insert the overlap
        List<int[]> results = new ArrayList<>();
        boolean notAddYet = true;
        for (int index = 0; index < intervals.length; index++) {
            int[] interval = intervals[index];
            if (notAddYet && interval[1] < overlapStart) { // the ele before the overlap
                results.add(interval);
            } else if (notAddYet && interval[0] >= overlapStart) { // add the ele once
                results.add(new int[]{overlapStart, overlapEnd});
                notAddYet = false;
                index--;
            } else if (!notAddYet && interval[0] > overlapEnd) { // the ele after the overlap
                results.add(interval);
            }
        }
        if (notAddYet)
            results.add(new int[]{overlapStart, overlapEnd});

        return results.toArray(new int[results.size()][]);
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        int[][] test = new int[1][];
        test[0] = new int[]{1, 2};
//        test[1] = new int[]{3, 5};
//        test[2] = new int[]{6, 7};
//        test[3] = new int[]{8, 10};
//        test[4] = new int[]{12, 16};
        int[] insertSlot = new int[]{4, 8};
        System.out.println(use.insert(test, insertSlot));
    }
}
