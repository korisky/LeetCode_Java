package Ex1_300.Ex121_to_150.Ex137_SingleNumber2;

/**
 * 方法在于, 对每一bit都进行求和, 因为都是int类型, 所以大家长度都是32bit,
 * 每一个bit都按bit进行求和, 并%3, 那么最后这一bit的数字, 就是那个没有出现3次的数留下的
 *
 * 注意: 对于bit的操作, 并不能简单的使用=作为赋值, 通常都要使用 |= 或者 &=
 */
public class Solution {
    public int singleNumber(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return 0;
        }
        int res = 0;
        // go through each bit
        for (int i = 0; i < 32; i++) {
            // sum for this bit
            int sum = 0;
            // go through all nums
            for (int num : nums) {
                // first get that bit by moving it to the last bit
                // then use & to get 0 / 1
                sum += (num >> i) & 1;
            }
            // cause usually it should appear 3 times
            sum %= 3;
            // set the bit back to it's pos, and store it in result
            res |= (sum << i);
        }
        return res;
    }
}
