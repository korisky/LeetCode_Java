package Ex50_Pow;

public class Solution {
    public double getPow(double x, long n) {
        if (n == 0) return 1.0;
        return n % 2 == 0 ? getPow(x * x, n / 2) : x * getPow(x * x, n / 2);
    }

    public double myPow(double x, int n) {
        return (long) n > 0 ? getPow(x, n) : 1.0 / getPow(x, -(long) n);
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        System.out.println(use.myPow(2.0, -2147483648));
    }
}
