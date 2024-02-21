package Ex181_to_210.Ex201BitwiseAND;

public class Solution {

    /**
     * 要求对range的所有数按为与, 重复处理
     */
    public int rangeBitwiseAnd(int left, int right) {
        while (right > left) {
            right = right & (right - 1);
        }
        return right & left;
    }
}
