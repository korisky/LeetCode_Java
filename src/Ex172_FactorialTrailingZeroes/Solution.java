package Ex172_FactorialTrailingZeroes;

/**
 * 问题是需要求解, 该数的阶层, 后面会有多少个0,
 * 实际上, 需要计算的是, 该数可以通过多少个5, 相乘, 来得到0, 所以转而计算5的出现次数
 */
public class Solution {
    public int trailingZeroes(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
    }
}
