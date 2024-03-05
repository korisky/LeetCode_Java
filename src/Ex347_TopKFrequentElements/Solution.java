package Ex347_TopKFrequentElements;

import java.util.*;

public class Solution {

    public static int[] topKFrequent(int[] nums, int k) {
        // 统计次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // PriorityQueue实现大顶堆, (a,b) -> b - a
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }
        // 取出前k个值
        int idx = 0;
        int[] result = new int[k];
        while (idx < k) {
            result[idx++] = maxHeap.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{5, 3, 1, 1, 1, 3, 73, 1};
        int[] ints1 = topKFrequent(ints, 2);
        for (int anInt : ints1) {
            System.out.print(anInt + " ");
        }
    }
}
