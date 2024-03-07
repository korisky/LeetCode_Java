package Ex1_300.Ex240_to_270.Ex268_MissingNumber;

/**
 * XOR, 使用亦或特性, a xor b xor b = a, 所以可以通过 xor遍历每一个数, 以及i, 从而得到空缺的某个数
 */
public class Solution {
    public int missingNumber(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor ^ nums.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{0, 2, 3, 5, 1};
        int i = s.missingNumber(test);
        System.out.println(i);
    }
}
