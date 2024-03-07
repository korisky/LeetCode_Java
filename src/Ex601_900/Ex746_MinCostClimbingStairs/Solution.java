package Ex601_900.Ex746_MinCostClimbingStairs;

/*
    We can start from jumping with jump[0] or jump[1],
    need to find out the lowest cost to jump to cost.length

    Instead of thinking from start or end, we need to drive the formula from 'MIDDLE'
    e.g. our current index is 2 in cost array of {1, 10, 5, 5}
        current cost is 5, what about the minimum cost to reach this index 2?
        that would be : checking index 0 and index 1: index 0 is smaller,
        then we can get MinCost[2] = Cost[2] + Math.min(Cost[0], Cost[1])

        What about the index 3? Similarly, MinCost[3] = Cost[3] + Math.min(Cost[1], Cost[2])
 */

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++)
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
