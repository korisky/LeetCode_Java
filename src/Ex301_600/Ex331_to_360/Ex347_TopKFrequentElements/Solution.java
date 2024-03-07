package Ex301_600.Ex331_to_360.Ex347_TopKFrequentElements;

import java.util.*;

public class Solution {

    /**
     * 由于统计频率一定不超过输入总数num, 尝试使用固定位置计数,
     * 类似BucketSort -> 知道最大最小值后, 进行映射即可实现具体idx操作, 方便统计频率
     */
    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] freqAppearList = new List[nums.length];

        // 初始化Array中的每个元素
        for (int i = 0; i < freqAppearList.length; i++) {
            freqAppearList[i] = new ArrayList<>();
        }

        // 遍历
        for (int num : nums) {
            Integer freq = map.getOrDefault(num, 0) + 1;
            // into list
            freqAppearList[freq - 1].add(num);
            // update map
            map.put(num, freq);
        }

        // 从频率最高到最低进行遍历
        int resIdx = 0;
        int[] res = new int[k];
        Set<Integer> resSet = new HashSet<>();
        for (int j = freqAppearList.length - 1; j >= 0; j--) {
            List<Integer> curList = freqAppearList[j];
            // 该频次下有数字, 进行添加
            if (!curList.isEmpty()) {
                for (Integer theNum : curList) {
                    // 直到超过数量
                    if (resIdx >= k) {
                        break;
                    }
                    // 保存过了
                    if (resSet.contains(theNum)) {
                        continue;
                    }
                    res[resIdx++] = theNum;
                    resSet.add(theNum);
                }
            }
            // 直到超过数量
            if (resIdx >= k) {
                break;
            }
        }
        return res;
    }


    /**
     * 使用最基础的方式, 结合Map遍历统计频率, 再添加到PriorityQueue中实现大顶堆, 获取前k个最大的元素
     */
    public static int[] topKFrequent_WithQueue(int[] nums, int k) {
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
//        int[] ints = new int[]{5, 3, 1, 1, 1, 3, 73, 1};
        int[] ints = new int[]{1, 1, 1, 2, 2, 3};
//        int[] ints1 = topKFrequent_WithQueue(ints, 2);
        int[] ints1 = topKFrequent(ints, 2);
        for (int anInt : ints1) {
            System.out.print(anInt + " ");
        }
    }
}
