package Ex3075_MaximizeHappinessSelectedChildren;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public long maximumHappinessSum(int[] happiness, int k) {

        // 维持一个PriorityQueue, 作为大顶堆使用
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int h : happiness) {
            pq.add(h);
        }

        // 持续找到最happy的, 并且需要-turn以及避免<0
        long hapSum = 0;
        int turn = 0;
        for (int i = 0; i < k; i++) {
            hapSum += Math.max(pq.poll() - turn, 0);
            turn++;
        }

        return hapSum;
    }
}
