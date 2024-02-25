package Ex973_KClosestPoints2Origin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        int[] l1 = new int[]{3, 3};
        int[] l2 = new int[]{5, -1};
        int[] l3 = new int[]{-2, 4};
        int[][] points = new int[][]{l1, l2, l3};
        int[][] ints = kClosest(points, 2);
        System.out.println();
    }


    static class Compact {
        int[] point;
        double distance;

        public Compact(int[] point, double distance) {
            this.point = point;
            this.distance = distance;
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        Queue<Compact> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(compact -> compact.distance));
        for (int[] point : points) {
            double dis = Math.pow(point[0], 2) + Math.pow(point[1], 2);
            priorityQueue.offer(new Compact(point, dis));
        }
        int idx = 0;
        while (!priorityQueue.isEmpty() && idx < k) {
            points[idx++] = priorityQueue.poll().point;
        }
        return Arrays.copyOf(points, k);
    }
}
