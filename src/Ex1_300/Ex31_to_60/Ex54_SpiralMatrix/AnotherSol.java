package Ex1_300.Ex31_to_60.Ex54_SpiralMatrix;

import java.util.*;
import java.util.stream.Collectors;

public class AnotherSol {

    public static void main(String[] args) {
        int[] row1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] row2 = new int[]{8, 9, 4};
//        int[] row3 = new int[]{7, 6, 5};

        int[][] matrix = new int[1][];
        matrix[0] = row1;
//        matrix[1] = row2;
//        matrix[2] = row3;

        List<Integer> integers = spiralOrder(matrix);
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }


    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Deque<Integer>> queueList = new LinkedList<>();
        for (int[] theInt : matrix) {
            queueList.add(
                    new LinkedList<>(
                            Arrays.stream(theInt).boxed().collect(Collectors.toList())));
        }

        List<Integer> result = new LinkedList<>();

        int dir = 1;
        while (!queueList.isEmpty()) {
            // left -> right
            if (dir == 1) {
                Deque<Integer> queue = queueList.removeFirst();
                result.addAll(queue);
                dir = 2;
                continue;
            }
            // up -> down
            if (dir == 2) {
                for (Deque<Integer> queue : queueList) {
                    result.add(queue.removeLast());
                    if (queue.isEmpty()) {
                        queueList.remove(queue);
                    }
                }
                dir = 3;
                continue;
            }
            // right -> left
            if (dir == 3) {
                Deque<Integer> queue = queueList.removeLast();
                result.addAll(queue.reversed());
                dir = 4;
                continue;
            }
            // down -> up
            if (dir == 4) {
                for (int i = queueList.size() - 1; i >= 0; i--) {
                    Deque<Integer> queue = queueList.get(i);
                    result.add(queue.removeFirst());
                    if (queue.isEmpty()) {
                        queueList.remove(queue);
                    }
                }
                dir = 1;
                continue;
            }
        }
        return result;
    }
}
