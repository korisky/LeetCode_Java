package Ex301_600.Ex571_to_600.Ex599_MinimumIndexTwoLists;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {

        if (list1.length > list2.length) {
            return findRestaurant(list2, list1);
        }

        Map<String, Integer> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            Integer j = map.get(list2[i]);
            if (null != j && i + j <= minSum) {
                if (i + j < minSum) {
                    res.clear();
                    minSum = i + j;
                }
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
