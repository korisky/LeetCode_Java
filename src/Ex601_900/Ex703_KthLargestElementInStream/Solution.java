package Ex601_900.Ex703_KthLargestElementInStream;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    /**
     * 设计一个结构, 每次add之后都会返回当前第k大的数, k是初始化得到的
     * 由于提供的class不包含删除, 可以简单的考虑每次都add
     */
    static class KthLargest {

        private int size;
        private Queue<Integer> topKQueue;

        public KthLargest(int k, int[] nums) {
            size = k;
            topKQueue = new PriorityQueue<>(k);
            for (int n : nums) {
                topKQueue.offer(n);
            }
            while (topKQueue.size() > k) {
                topKQueue.poll();
            }
        }

        public int add(int val) {
            topKQueue.offer(val);
            while (topKQueue.size() > size) {
                topKQueue.poll();
            }
            return topKQueue.element();
        }
    }

    public static void main(String[] args) {
        KthLargest ins = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(ins.add(3));
        System.out.println(ins.add(5));
        System.out.println(ins.add(10));
        System.out.println(ins.add(9));
        System.out.println(ins.add(4));
    }

}
