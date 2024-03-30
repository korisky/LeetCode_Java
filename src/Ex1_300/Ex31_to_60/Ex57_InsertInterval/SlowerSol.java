package Ex1_300.Ex31_to_60.Ex57_InsertInterval;

import java.util.*;

public class SlowerSol {

    /**
     * 区间合并, 最主要还是需要先进行左边界的排序, 然后维持右边界的拓展,
     * 但是该方法的时间复杂度是O(nLogN), 最优解应该是O(n)
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {

        // 添加 & 排序, O(nlogN)
        List<int[]> intervalList = new LinkedList<>();
        for (int[] inter : intervals) {
            intervalList.add(inter);
        }
        intervalList.add(newInterval);
        Collections.sort(intervalList, Comparator.comparingInt(a -> a[0]));

        // 遍历增长right, O(n)
        List<int[]> result = new LinkedList<>();
        Iterator<int[]> iterator = intervalList.iterator();
        int[] first = iterator.next();
        int left = first[0];
        int right = first[1];
        while (iterator.hasNext()) {
            int[] cur = iterator.next();
            if (cur[1] <= right) {
                // 已经包含, 不进行处理

            } else if (cur[0] <= right) {
                // 有重合或衔接, 进行右边界拓展
                right = cur[1];
            } else {
                // 不重合, 添加上一个区间, 更新left & right
                result.add(new int[]{left, right});
                left = cur[0];
                right = cur[1];
            }
        }

        // 加上最后一个区间
        result.add(new int[]{left, right});
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        SlowerSol use = new SlowerSol();
        int[][] test = new int[4][];
        test[0] = new int[]{1, 5};
        test[1] = new int[]{3, 5};
        test[2] = new int[]{3, 6};
        test[3] = new int[]{8, 10};
//        test[4] = new int[]{12, 16};
        int[] insertSlot = new int[]{9, 15};

        int[][] result = use.insert(test, insertSlot);
        for (int[] res : result) {
            System.out.println(res[0] + " " + res[1]);
        }
    }
}
