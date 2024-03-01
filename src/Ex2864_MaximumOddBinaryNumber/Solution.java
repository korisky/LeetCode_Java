package Ex2864_MaximumOddBinaryNumber;

public class Solution {

    public static void main(String[] args) {
        System.out.println(maximumOddBinaryNumber("010110")); // 110001
        System.out.println(maximumOddBinaryNumber("111111"));
        System.out.println(maximumOddBinaryNumber("0001"));
        System.out.println(maximumOddBinaryNumber("0000"));
        System.out.println(maximumOddBinaryNumber("1000"));
        System.out.println(maximumOddBinaryNumber("10"));
        System.out.println(maximumOddBinaryNumber("1000010")); // 1000001
        System.out.println(maximumOddBinaryNumber("100001"));
    }

    /**
     * 问题需要使用对内部的bit进行排列, 得到最大的奇数(最后一位必须要是1)
     * 重点在于存储一个index, 持续遍历, 遇到1就swap到前面, 最后一位swap为1需要判断前面有没有swap过
     */
    public static String maximumOddBinaryNumber(String s) {
        // 遍历string, 将后面不是1的都swap到前面
        int lastOneDigIdx = 0;
        char[] charArray = s.toCharArray();
        boolean oneNum = charArray[0] == '1';
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '1') {
                // swap
                char tmp = charArray[lastOneDigIdx];
                charArray[lastOneDigIdx] = charArray[i];
                charArray[i] = tmp;
                lastOneDigIdx++;
                // sum
                oneNum = true;
            }
        }
        // 没有1, 直接返回
        if (!oneNum) {
            return s;
        }
        // 最后一个1的位置, swap到最后一位, 确保奇数
        int maxIdx = charArray.length - 1;
        if (charArray[maxIdx] != '1') {
            charArray[maxIdx] = '1';
            if (lastOneDigIdx == 0) {
                charArray[0] = '0';
            } else {
                charArray[lastOneDigIdx - 1] = '0';
            }
        }
        return new String(charArray);
    }
}
