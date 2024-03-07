package Ex1_300.Ex1_to_30.Ex29_Divide2Integers;

public class divide_S {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean sign = (dividend ^ divisor) >= 0;

        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        int sum = 0;
        int middle = divisor;
        int count = 1;
        int remain = dividend;

        while (remain <= divisor) {
            // negtive number needs add 1 before right shift
            while (middle >= ((remain+1) >> 1)) {
                middle <<= 1;
                count <<= 1;
            }

            if (middle >= remain) {
                sum += count;
                remain -= middle;
            }

            middle >>= 1;
            count >>= 1;
        }

        return sign ? sum : -sum;
    }
}
