package Ex1_300.Ex270_to_300.Ex295_FindMedianDataStream;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Hard 难度 - 题目希望我们维持一个中位数finder, 每次可以O(1)的时间找到当前加入元素的中位数
 */
public class Solution {

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    static class MedianFinder {

        // 大顶堆, 大的部分在最前面, 保存小的那一半数据 (左边)
        private PriorityQueue<Integer> left;

        // 小顶堆, 小的部分在最前面, 保存大的那一半数据 (右边)
        private PriorityQueue<Integer> right;
        private boolean even = true; // 0 为偶数

        /**
         * 使用双Heap - 大顶堆 小顶堆, 核心是奇数和偶数情况下, 每次将新数字加入到其中一边 (负责保存小的那一半的数字), 然后poll出来插入到另一边
         */
        public MedianFinder() {
            this.left = new PriorityQueue<>(Collections.reverseOrder());
            this.right = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (even) {
                // 现在是偶数, 所以添加后是奇数, 也就是左边会多1个, 这个时候先插入右边, 再peek最小的放入左边
                right.offer(num);
                left.offer(right.poll());
            } else {
                // 现在是奇数, 所以添加后是偶数, 两边平衡, 所以先插入左边, 再peek左边最大的放入右边
                left.offer(num);
                right.offer(left.poll());
            }
            // 扭转
            even = !even;
        }

        public double findMedian() {
            return !even
                    ? left.peek() // 奇数规定, 大顶堆比小顶堆多1个, 所以直接peek大顶堆最大的就是中位数
                    : ((left.peek() + right.peek()) / 2.0); // 偶数两个堆平衡, 同时peek求平均
        }
    }

}
