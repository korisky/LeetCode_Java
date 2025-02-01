package Ex3151_SpecialArrayI;

public class Solution {

    /**
     * 判断相邻num是否奇偶间隔, 使用异或进行判断
     */
    public static boolean isArraySpecial(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return true;
        }
        // last bit for first element
        int lb = nums[0] & 1;
        for (int i = 1; i < nums.length; i++) {
            // keep comparing by using XOR
            int curLb = nums[i] & 1;
            if (0x0 == (lb ^ curLb)) {
                return false;
            }
            // update
            lb = curLb;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isArraySpecial(new int[]{1, 6, 2}));
        System.out.println(isArraySpecial(new int[]{2, 1, 4}));
        System.out.println(isArraySpecial(new int[]{4, 3, 1, 6}));
    }
}
