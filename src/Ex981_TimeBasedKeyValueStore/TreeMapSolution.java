package Ex981_TimeBasedKeyValueStore;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * 问题重点在于, get方法如果输入的key(也就是timestamp)如果没有, 需要用最近更新的(刚好比这个key小的, 最大的key)
 * 的值进行返回, TreeMap自带一个floorKey方法, 完全符合需要构造的情况
 */
public class TreeMapSolution {

    private final HashMap<String, TreeMap<Integer, String>> map;

    public TreeMapSolution() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> timeMap;
        if (this.map.containsKey(key)) {
            timeMap = this.map.get(key);
        } else {
            timeMap = new TreeMap<>();
            map.put(key, timeMap);
        }
        timeMap.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (this.map.containsKey(key)) {
            TreeMap<Integer, String> timeMap = this.map.get(key);
            // special problem, we need that floor key (the greater key that less than current key)
            Integer floorKey = timeMap.floorKey(timestamp);
            return timeMap.get(floorKey);
        }
        return null;
    }
}
