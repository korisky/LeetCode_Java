package Ex2696_MinimumStringLenAfterRemovingSubstrings;

public class Solution {

    /**
     * Ex2696 -> 反向指针匹配发, 一旦遇到第一个AB/CD字符串, 其中一个指针开始向后寻找
     * 并且只需要记录index作为剩余长度即可
     */
    public static int minLength(String s) {

        int writePrt = 0;
        char[] charArr = s.toCharArray();

        for (int readPrt = 0; readPrt < s.length(); readPrt++) {
            charArr[writePrt] = charArr[readPrt];
            if (writePrt > 0
                    && (charArr[writePrt - 1] == 'A' || charArr[writePrt - 1] == 'C')
                    && charArr[writePrt] == charArr[writePrt - 1] + 1) {
                writePrt--;
            } else {
                writePrt++;
            }
        }
        return writePrt;
    }


}
