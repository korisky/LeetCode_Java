package Ex1801_2100.Ex2064_MinimizedMaximumOfProductsDistributedAnyStore;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    /**
     * 题目意思是, 有n个品类的商品, 每个的数量是quantities. 需要找到每个店铺库存最小的分配方式(每个店铺只能hold住一种类别)
     * 相较于使用BinarySearch, Leetcode提供了每次找到当前ratio最大的店, 然后持续的切分分配的贪心算法
     */
    public int minimizedMaximum(int n, int[] quantities) {

        int m = quantities.length;
        List<int[]> typeStorePairsArray = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            typeStorePairsArray.add(new int[]{quantities[i], 1});
        }

        PriorityQueue<int[]> typeStorePairs = new PriorityQueue<>(
                (a, b) -> Long.compare((long) b[0] * a[1], (long) a[0] * b[1])
        );

        typeStorePairs.addAll(typeStorePairsArray);

        for (int i = 0; i < n - m; i++) {
            int[] pairWithMaxRatio = typeStorePairs.poll();
            int totalQuantityOfType = pairWithMaxRatio[0];
            int storesAssignedToType = pairWithMaxRatio[1];

            typeStorePairs.offer(new int[]{totalQuantityOfType, storesAssignedToType + 1});
        }

        // pop the first ele
        int[] pairWithMaxRatio = typeStorePairs.poll();
        int totalQuantityOfType = pairWithMaxRatio[0];
        int storeAssignedToType = pairWithMaxRatio[1];

        return (int) Math.ceil(
                // 这里一定要使用double先, 否则会被剔除小数, ceiling达不到效果
                (double) totalQuantityOfType / storeAssignedToType);
    }
}
