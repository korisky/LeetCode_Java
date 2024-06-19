package Ex1201_1500.Ex1482_MinimumNumberDaysMakeBouquets;

public class Solution {

    /**
     * 题目给出 bloomDay数据, 里面数字是花开的日子, 需要找到连续为k的花, 一共做m个花圈
     */
    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length, left = 1, right = (int) 1e9;

        // 对于int类型的乘法, 都需要考虑溢出的问题
        if ((long) m * k > n) {
            return -1;
        }

        while (left < right) {
            int mid = (left + right) / 2, flow = 0, bouq = 0;
            for (int j = 0; j < n; j++) {
                if (bloomDay[j] > mid) {
                    flow = 0;
                } else if (++flow >= k) {
                    bouq++;
                    flow = 0;
                }
            }
            if (bouq < m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
