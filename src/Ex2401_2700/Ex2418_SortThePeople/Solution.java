package Ex2401_2700.Ex2418_SortThePeople;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static String[] sortPeople(String[] names, int[] heights) {
        // 直接使用TreeMap, 由于是根据Key排序, 使用height作为key
        TreeMap<Integer, String> treeMap = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < heights.length; i++) {
            treeMap.put(heights[i], names[i]);
        }
        // 由于已经排序, 直接entrySet就是从大到小遍历
        int i = 0;
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            names[i++] = entry.getValue();
        }
        return names;
    }

    public static void main(String[] args) {
        String[] strings = sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170});
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
