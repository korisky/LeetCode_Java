package Ex3160_FindNumDistinctColorsAmongBalls;

import java.util.*;

public class Solution {

    /**
     * 题目要求记录, 每次轮次修改后, 当前的distinct的颜色是多少个, 尝试使用2个Set来进行操作跟踪
     * merge(key, delta, BiFunction) -> 可以看作是
     * - 如果不存在key, 那么我们给它put(key, delta)
     * - 如果存在key, 那么我们使用BiFunction来处理
     * - - BiFunction 中的 (a, b), 对应的a就是原来的值, b就是传入的delta
     */
    public static int[] queryResults(int limit, int[][] queries) {

        // init ball's color
        Map<Integer, Integer> ballColorMap = new HashMap<>();

        // init color for balls
        Map<Integer, Integer> colorBallMap = new HashMap<>();

        // simulation
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int ball = query[0];
            int color = query[1];

            // update new ball's color & retrieve old value
            Integer oldColor = ballColorMap.put(ball, color);

            // 1) decrease old color's size if present
            if (!Objects.isNull(oldColor)) {
                // decrease val or eliminate whole key
                colorBallMap.merge(oldColor, -1,
                        (oldCount, delta) -> (oldCount + delta) == 0 ? null : oldCount + delta);
            }

            // 2) update for color's ball size
            colorBallMap.merge(color, 1, Integer::sum);

            // 3) record answer
            result[i] = colorBallMap.size();
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] input = {{1, 4}, {2, 5}, {1, 3}, {3, 4}};
        queryResults(4, input);
    }
}
