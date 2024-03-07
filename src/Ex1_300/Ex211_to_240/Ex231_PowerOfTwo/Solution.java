package Ex1_300.Ex211_to_240.Ex231_PowerOfTwo;

public class Solution {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo(5));
        System.out.println(isPowerOfTwo(6));
        System.out.println(isPowerOfTwo(8));
        System.out.println(isPowerOfTwo(9));
        System.out.println(isPowerOfTwo(10));
    }

    public static boolean isPowerOfTwo(int n) {
        // n == 1 -> 2^0
        // n != 1 -> bit operation -> n & n - 1 (then this must return 0 as power of 2)
        // need to take care of -> n < 0 && n == 0
        return n == 1 || (n > 0 && ((n & n - 1) == 0));
    }
}
