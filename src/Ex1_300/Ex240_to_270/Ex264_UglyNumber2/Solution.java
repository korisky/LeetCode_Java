package Ex1_300.Ex240_to_270.Ex264_UglyNumber2;

public class Solution {

    /**
     * 接近动态规划的计算, 由于uglyNumber一定是2，3，5相乘，所以一定是由这几个数进行计算
     * 而其中每次计算填入到队列中, 都是从最小的进行填入
     */
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        // 需要考虑, 从1开始, 因为0已经是填入的1的数值
        for (int i = 1; i < n; i++) {
            int min = Math.min(factor2, Math.min(factor3, factor5));
            ugly[i] = min;
            if (factor2 == min) {
                factor2 = 2 * ugly[++idx2];
            }
            if (factor3 == min) {
                factor3 = 3 * ugly[++idx3];
            }
            if (factor5 == min) {
                factor5 = 5 * ugly[++idx5];
            }
        }
        return ugly[n - 1];
    }
}
