package Ex301_600.Ex361_to_390.Ex380_InsertDeleteGetRandom;

import java.util.*;

public class Solution {


    /**
     * 题目意思是, 插入之后的数据, 要和已经在的部分获取同样的选择可能性
     */
    static class RandomizedSet {

        List<Integer> values;

        Map<Integer, Integer> valueToIdxMap;

        Random rand;


        public RandomizedSet() {
            values = new ArrayList<>();
            valueToIdxMap = new HashMap<>();
            rand = new Random();
        }

        public boolean search(int val) {
            return valueToIdxMap.containsKey(val);
        }

        public boolean insert(int val) {
            if (search(val)) {
                return false;
            }
            valueToIdxMap.put(val, values.size());
            values.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!search(val)) {
                return false;
            }

            // 使用这个操作, 将最后元素放到被删除的元素的位置
            Integer idx = valueToIdxMap.get(val);
            Integer lastEle = values.get(values.size() - 1);
            values.set(idx, lastEle);

            // 这个元素对应的list的size应该就是这个位置
            valueToIdxMap.put(lastEle, idx);

            // 删除最后一位
            values.remove(values.size() - 1);
            valueToIdxMap.remove(val);
            return true;
        }

        public int getRandom() {
            return values.get(rand.nextInt(values.size()));
        }
    }
}
