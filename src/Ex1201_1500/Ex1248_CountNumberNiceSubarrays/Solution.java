package Ex1201_1500.Ex1248_CountNumberNiceSubarrays;

public class Solution {
    /**
     * 与Ex992类似, 出现k次 = 最多k次 - 最多k-1次
     */
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    /**
     * 这里与Ex992的方法一样, 使用一个Slicing Window,
     * 刚好连续的子序列的数目 = 当前j - i + 1的长度
     */
    public int atMost(int[] A, int k) {
        int res = 0, i = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            k -= A[j] % 2;
            while (k < 0) {
                k += A[i++] % 2;
            }
            res += j - i + 1;
        }
        return res;
    }
}
