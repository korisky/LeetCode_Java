package Ex61_to_90.Ex66_PlusOne;

public class Solution {
    public int[] plusOne(int[] digits) {
        for (int index = digits.length - 1; index >= 0; index--) {
            if (digits[index] < 9) {
                digits[index]++;
                return digits;
            } else {
                digits[index] = 0;
            }
        }
        int[] addOne = new int[digits.length + 1];
        addOne[0] = 1;
        return addOne;
    }
}
