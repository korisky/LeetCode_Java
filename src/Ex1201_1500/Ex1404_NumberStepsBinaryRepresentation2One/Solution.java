package Ex1201_1500.Ex1404_NumberStepsBinaryRepresentation2One;

public class Solution {


    /**
     * 将二进制字符串转换为1需要的步骤, 每次遇到1就+1, 遇到0就>>
     */
    public int numSteps(String s) {
        int ops = 0;
        int carry = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            int digit = Character.getNumericValue(s.charAt(i)) + carry;
            if (digit % 2 == 1) {
                ops += 2;
                carry = 1;
            } else {
                ops++;
            }
        }
        return ops + carry;
    }
}
