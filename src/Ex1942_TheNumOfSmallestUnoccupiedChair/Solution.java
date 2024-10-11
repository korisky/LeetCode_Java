package Ex1942_TheNumOfSmallestUnoccupiedChair;

import java.util.*;

public class Solution {

    /**
     * 题目需要找到对应target当时入座的位置
     */
    public int smallestChair(int[][] times, int targetFriend) {

        int n = times.length;
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        // 根据入座时间进行排序
        Arrays.sort(order, Comparator.comparingInt(a -> times[a][0]));

        // 使用两个PriorityQueue进行出入座模拟, 其中 takenSeats 存放的是当前座位(正在占座), 以及离开时间
        PriorityQueue<Integer> emptySeats = new PriorityQueue<>();
        PriorityQueue<int[]> takenSeats = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < n; i++) {
            emptySeats.offer(i);
        }

        // 按照入座顺序进行便利
        for (Integer i : order) {
            int arrival = times[i][0], leave = times[i][1];

            // 如果目前有人已经入座, 并且离座的时间小于当前入座时间, 剔除为emptySeat
            while (!takenSeats.isEmpty() && takenSeats.peek()[1] <= arrival) {
                emptySeats.offer(takenSeats.poll()[0]);
            }

            // 从空座位中找一个
            int seat = emptySeats.poll();
            if (i == targetFriend) {
                return seat;
            }

            // 否则, 从takenSet中传入参数, 内部进行
            takenSeats.offer(new int[]{seat, leave});
        }

        return -1;
    }
}
