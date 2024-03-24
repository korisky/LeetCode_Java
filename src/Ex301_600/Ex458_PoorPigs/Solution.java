package Ex301_600.Ex458_PoorPigs;

public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // 最大测试次数
        int totalTestNum = minutesToTest / minutesToDie;
        // 数学法则: 每一次相当于 (totalTestNum + 1)种情况, 每有一只猪, 就能有一种这个情况
        // 所以: (totalTestNum + 1) ^ pig
        int pigs = 0;
        while (Math.pow(totalTestNum + 1, pigs) < buckets) {
            pigs++;
        }
        return pigs;
    }
}
