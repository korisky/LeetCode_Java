package Ex509_FibonacciNumber;

public class Solution {
    public int fib(int N) {
        if (N <= 1)
            return N;
        int prevPrev = 0;
        int prev = 1;
        for (int i = 2; i <= N; i++) {
            int cur = prevPrev + prev;
            prevPrev = prev;
            prev = cur;
        }
        return prev;
    }
}
