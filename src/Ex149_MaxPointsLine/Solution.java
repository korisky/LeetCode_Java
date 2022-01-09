package Ex149_MaxPointsLine;

import java.util.HashMap;
import java.util.Map;

/**
 * 问题实际上需要要到 最大公约数 - 辗转相除法
 */
public class Solution {
    public int maxPoints(int[][] points) {
        if (null == points) {
            return 0;
        }
        int n = points.length;
        if (n < 2) {
            return n;
        }
        int solution = 1;
        // run from each point
        for (int i = 0; i < n - 1; i++) {
            // fast cut if the solution already > 1/2 of whole points
            if (solution >= n - i || solution > n / 2) {
                return solution;
            }
            int[] pi = points[i];
            Map<Integer, Integer> map = new HashMap<>();
            // go through other points
            for (int j = i + 1; j < n; j++) {
                int[] pj = points[j];
                int diffx = pi[0] - pj[0];
                int diffy = pi[1] - pj[1];
                if (diffy == 0) {
                    diffx = 1;
                } else if (diffx == 0) {
                    diffy = 1;
                } else {
                    if (diffy < 0) {
                        diffy = - diffy;
                        diffx = - diffx;
                    }
                    int gcd = gcd(Math.abs(diffx), Math.abs(diffy));
                    diffx /= gcd;
                    diffy /= gcd;
                }
                int key = diffx + diffy * 20000;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            for (Integer key : map.keySet()) {
                solution = Math.max(solution, map.get(key) + 1);
            }
        }
        return solution;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] test = new int[][]{{1, 1}, {2, 2}, {3, 3}};
        int i = s.maxPoints(test);
    }
}
