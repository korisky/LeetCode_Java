package Ex692_TopKFrequentWords;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String[] stringArr = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        Iterator<String> iterator = topKFrequent(stringArr, 2).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 获取topK个出现频次最高的词
     */
    public static List<String> topKFrequent(String[] words, int k) {
        // 统计频率
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        // 排序
        Queue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(
                // 当PriorityQueue为复合类型, 可能需要多多个属性进行比对
                (a, b) -> {
                    // 首先比对value
                    int val = b.getValue() - a.getValue();
                    // 相同的情况下, 使用key比对, String类型自动按照字母顺序排序
                    return val == 0 ? a.getKey().compareTo(b.getKey()) : val;
                });
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            priorityQueue.add(entry);
        }
        // 提取topK
        int idx = 0;
        List<String> result = new LinkedList<>();
        while (idx++ < k) {
            result.add(priorityQueue.poll().getKey());
        }
        return result;
    }
}
