package Ex1_300.Ex31_to_60.Ex56_MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class AnotherSol {

    /**
     * 严格来说并不是MergeSort, 核心在于如何如何如果判断Overlap
     */
    public int[][] merge(int[][] intervals) {

        // conner case
        if (intervals.length == 1) {
            return intervals;
        }

        // 因为每次都需要从左区间进行大小判断, 这里最好提前进行一个排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        // 因为是从小到大进行区间判断, 遍历时添加一个区间段后, 立刻要使用新的最小和最大进行判断
        List<int[]> result = new LinkedList<>();
        int curMin = Integer.MAX_VALUE;
        int curMax = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] <= curMax) {
                // overlap, 当前区间的最小值小于上一个区间的最大值, 可以合并拓展
                curMax = Math.max(curMax, interval[1]);
            } else {
                // 没有overlap, 添加上一个区间, 该区间最小最大值作为搜索
                result.add(new int[]{curMin, curMax});
                curMin = interval[0];
                curMax = interval[1];
            }
        }

        // 为最后一个区间填补
        result.add(new int[]{curMin, curMax});

        // 第一个区间是从-infinity开始的, 可以去除
        result.removeFirst();

        // 从List转回Array
        return result.toArray(new int[result.size()][]);
    }
}
