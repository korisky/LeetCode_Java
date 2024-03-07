package Ex901_1200.Ex1137_NthTribonacciNumber;

public class Solution {
    public int tribonacci(int n) {
        if (n <= 1)
            return n;
        if (n == 2)
            return 1;

        int t0 = 0;
        int t1 = 1;
        int t2 = 1;

        for (int i = 3; i <= n; i++) {
            int t3 = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = t3;
        }
        return t2;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        System.out.println(use.tribonacci(25));
    }
}
