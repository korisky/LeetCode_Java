package Ex301_600.Ex361_to_390.Ex378_KthSmallestElementSortedMatrix;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    static class ValAndRow {
        int val;
        int row;

        public ValAndRow(int val, int row) {
            this.val = val;
            this.row = row;
        }
    }

    /**
     * 类似MergeSort, 但需要额外记录每行当前idx, 该版本为基础版本,
     * 魔改极致性能版, 则是通过搜索, 定位查找的minK个元素, 应该在matrix的哪一行哪个位置
     */
    public static int kthSmallest(int[][] matrix, int k) {

        // 初始
        int[] rowIdxMatrix = new int[matrix.length];

        // queue, 从小到大
        Queue<ValAndRow> priorityQueue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int row = 0; row < matrix.length; row++) {
            priorityQueue.add(new ValAndRow(matrix[row][0], row));
        }

        // 找到第n个
        int kMin = 0;
        int skipNum = 0;
        while (skipNum++ < k) {
            // 提取最小值
            ValAndRow curMin = priorityQueue.poll();
            kMin = curMin.val;
            // 那一行的指针右移
            rowIdxMatrix[curMin.row]++;
            // 如果当前行还没到达行尾, 添加该行下一个元素
            if (rowIdxMatrix[curMin.row] < matrix[curMin.row].length) {
                // queue添加这一行的下一列元素
                priorityQueue.add(
                        new ValAndRow(
                                matrix[curMin.row][rowIdxMatrix[curMin.row]],
                                curMin.row));
            }
        }
        return kMin;
    }

    public static void main(String[] args) {
        int[] row1 = new int[]{1, 5, 9};
        int[] row2 = new int[]{10, 11, 13};
        int[] row3 = new int[]{12, 13, 15};
        int[][] matrix = new int[][]{row1, row2, row3};
        System.out.println(kthSmallest(matrix, 8));
    }
}
