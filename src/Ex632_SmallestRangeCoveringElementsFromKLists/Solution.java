package Ex632_SmallestRangeCoveringElementsFromKLists;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {

        int curMax = Integer.MIN_VALUE;
        int minRange = Integer.MAX_VALUE;
        int[] minRangeIdx = new int[2];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        // using a mixed type min-heap, to store the value and index of a list.
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            minHeap.offer(new int[]{list.get(0), i});
            curMax = Math.max(curMax, list.get(0)); // keep updating the current maximum value
        }

        while (!minHeap.isEmpty()) {
            int[] curNode = minHeap.poll();
            int curMin = curNode[0];
            int idx = curNode[1];
            if (curMax - curMin < minRange) { // update the minimum range
                minRange = curMax - curMin;
                minRangeIdx[0] = curMin;
                minRangeIdx[1] = curMax;
            }
            if (nums.get(idx).size() > 1) {
                // here is about: if that would be the last element, we should stop
                // update
                nums.get(idx).remove(0); // the remove and get would be constant time
                int addNum = nums.get(idx).get(0);
                curMax = Math.max(curMax, addNum);
                minHeap.offer(new int[]{addNum, idx});
            } else {
                break;
            }
        }
        return minRangeIdx;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        int[] s1 = new int[]{4, 10, 15, 24, 26};
        List<Integer> l1 = Arrays.stream(s1).boxed().collect(Collectors.toList());
        int[] s2 = new int[]{0, 9, 12, 20};
        List<Integer> l2 = Arrays.stream(s2).boxed().collect(Collectors.toList());
        int[] s3 = new int[]{5, 18, 22, 30};
        List<Integer> l3 = Arrays.stream(s3).boxed().collect(Collectors.toList());

        List<List<Integer>> test = new ArrayList<>();
        test.add(l1);
        test.add(l2);
        test.add(l3);

        int[] res = use.smallestRange(test);
        for (int i : res)
            System.out.println(i);
    }
}
