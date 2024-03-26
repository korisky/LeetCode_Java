package Ex2498_FrogJumpII;

public class Solution {

    /**
     * 403问题的第二版, 同样需要使用动态规划, 但存在一个极致简单的解法
     */
    public int maxJump(int[] stones) {
        int res = stones[1] - stones[0], n = stones.length;
        for (int i = 2; i < n; i++) {
            // 这里的 stones[i] - stones[i-2]的意思是
            // 1. 这里的来回, 可以看作是2只青蛙同时从start出发, 除了起点终点相同, 其他都不同
            // 2. 那么这里可以使用greedy算法, 因为分配了第一只青蛙这个石头i之后, 一定是分配给第二只青蛙下一个石头, 才可能尽可能的让最大步长更短
            // 3. 所以这里每一次分配时的步长, 都是对比 stones[i] - stones[i - 2]
            res = Math.max(res, stones[i] - stones[i - 2]);
        }
        return res;
    }
}
