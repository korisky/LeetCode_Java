package Ex407_TrappingRainWater2;

/*
    Method from LeetCode:
        Keep traversing from boundaries to centre, with a priority queue.
        In 2-d, a water can be contained only when 4 direction both higher than the centre one.
        BUT, we can simplify it below:
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    final int[][] fourDirection = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = (m == 0 ? 0 : heightMap[0].length);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        // here we use Lambda Expression, means: every elements in Priority Queue, we
        // use it's 3rd element to compare them. (a, b) -> a - b means we set the
        // smaller element would have more priority.

        boolean[][] visited = new boolean[m][n]; // 2-d searching space much use visited

        // add left and right boundaries
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]}); // offer would not occur Exception
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = visited[i][n - 1] = true;
        }

        // add top and bottom boundaries
        for (int j = 1; j < n; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = visited[m - 1][j] = true;
        }

        int res = 0;
        while (!pq.isEmpty()) {
            int[] curCell = pq.poll();

            for (int[] neighbour : fourDirection) {
                int r = curCell[0] + neighbour[0]; // get one of it's four direction's neighbour
                int c = curCell[1] + neighbour[1];
                if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c])
                    continue;
                res += Math.max(0, curCell[2] - heightMap[r][c]); // if neighbour's height is greater than curCell's
                                                                // we get their difference, else 0
                pq.offer(new int[]{r, c, Math.max(curCell[2], heightMap[r][c])});
                // Here is the crucial step:
                // If curCell is higher than its' neighbour, then this neighbour's HEIGHT would be updated
                // with the Height of curCell. Then if we meet some slots of this neighbour's neighbour, with a same
                // or even higher Height. Res would add nothing, because containing how much water is determined by
                // the shortest slot (this curCell's one). Otherwise, it can still add reasonable volume.

                visited[r][c] = true;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(x -> -x));
        pq.add(10);
        pq.add(5);
        System.out.println(pq.peek());
    }
}
