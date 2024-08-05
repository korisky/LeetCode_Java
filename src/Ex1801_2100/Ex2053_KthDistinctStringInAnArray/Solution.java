package Ex1801_2100.Ex2053_KthDistinctStringInAnArray;

import java.util.HashMap;

public class Solution {

    /**
     * 题目要求找到从左到右第k个唯一的string
     */
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> freqMap = new HashMap<>();
        for (String str : arr) {
            Integer freq = freqMap.getOrDefault(str, 0);
            freqMap.put(str, freq + 1);
        }
        for (String str : arr) {
            if (1 == freqMap.get(str)) {
                k--;
            }
            if (k == 0) {
                return str;
            }
        }
        return "";
    }
}
