package Ex601_900.Ex846_HandStraights;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {

        Map<Integer, Integer> countMap = new TreeMap<>();
        for (int i : hand) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        int lastChecked = -1, opened = 0;
        Queue<Integer> start = new LinkedList<>();
        for (int i : countMap.keySet()) {
            if (opened > 0 && i > lastChecked + 1 || opened > countMap.get(i)) {
                return false;
            }
            start.add(countMap.get(i) - opened);
            lastChecked = i;
            opened = countMap.get(i);
            if (start.size() == groupSize) {
                opened -= start.remove();
            }
        }

        return opened == 0;
    }
}
