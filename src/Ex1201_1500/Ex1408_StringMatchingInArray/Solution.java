package Ex1201_1500.Ex1408_StringMatchingInArray;

import java.util.*;

public class Solution {

    /**
     * 通过排序从小到大
     */
    public static List<String> stringMatching(String[] words) {

        PriorityQueue<String> acsQueue = new PriorityQueue<>(Comparator.comparingInt(String::length));
        acsQueue.addAll(Arrays.asList(words));

        // use treeSet is more efficient -> sorted + ordered remain
        Set<String> result = new HashSet<>();
        TreeSet<String> sortedSet = new TreeSet<>();
        while (!acsQueue.isEmpty()) {
            String cur = acsQueue.poll();
            for (String existing : sortedSet) {
                if (cur.contains(existing)) {
                    result.add(existing);
                }
            }
            sortedSet.add(cur);
        }
        return result.stream().toList();
    }


    public static void main(String[] args) {
        System.out.println(stringMatching(new String[]{"leetcode", "et", "code"}));
    }
}
