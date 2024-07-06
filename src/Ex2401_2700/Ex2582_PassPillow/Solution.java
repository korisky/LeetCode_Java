package Ex2401_2700.Ex2582_PassPillow;

public class Solution {

    /**
     * 题目寻找time之后到达的位置, 核心在于通过 2n - 2 的时间可以回到原点, 那么取模后再进行simulation最可行
     */
    public static int passThePillow(int n, int time) {
        int remain = time % (2 * n - 2);
        if (remain > n - 1) {
            return n - (remain - (n - 1));
        } else {
            return remain + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(passThePillow(4, 5));
        System.out.println(passThePillow(3, 2));
    }
}
