package Ex260_SingleNumber3;

/**
 * 同样使用XOR先进行第一次遍历, 得到结果为 A XOR B,
 * 而此时选择从左到右最早不同的一位 (rightmost set bit, https://www.techiedelight.com/bit-hacks-part-3-playing-rightmost-set-bit-number/),
 * 将这一位不为0的所有数字的整体进行XOR, 此时得到的就是A, 而根据 A XOR (A XOR B), 我们可以得到第二个数字B
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return null;
        }
        // 1. get a XOR b first
        int aXORb = 0;
        for (int num : nums) {
            aXORb ^= num;
        }
        // 2. find the rightmost different bit, then XOR all nums that
        // is not 0 on this bit
        int rightMostBit = aXORb & -aXORb;
        int a = 0;
        for (int num : nums) {
            // means this num is responsible for this XOR, we need to XOR it
            if ((num & rightMostBit) != 0) {
                a ^= num;
            }
        }
        // 3. return the result
        return new int[]{a, aXORb ^ a};
    }
}
