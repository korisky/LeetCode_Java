package Ex136_SingleNumber;

/**
 * 按位亦或, 出现偶数次的数最后得到0
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
