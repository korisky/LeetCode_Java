package Ex301_600.Ex451_to_480.Ex452_MinimumNumArrowsBurstBalloons;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    /**
     * 题目的start和end代表气球所在位置, end - start即气球直径,
     * 通过对气球end进行排序 (尽可能向右, 则可以打到更多气球), 即可使用Greedy完成
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        // 对气球的end进行排序
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        // 初始化第一箭
        int curRightPos = points[0][1];
        int arrowCount = 1;
        // 从第二个气球开始遍历
        for (int i = 1; i < points.length; i++) {
            // 对于在同一箭穿过了的气球左边, 可以跳过
            if (points[i][0] <= curRightPos) {
                continue;
            }
            // 新的一发
            arrowCount++;
            curRightPos = points[i][1];
        }
        return arrowCount;
    }
}
