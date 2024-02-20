package Ex151_to_180.Ex168_ExcelSheetColumnTitle;

/**
 * 相对于使用正向的计算, 从右往左取余, 最后reverse的算法速度快很多
 */
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int r = n % 26;
            n = n / 26;
            if (r != 0) {
                sb.append((char) (r - 1 + 'A'));
            } else {
                sb.append('Z');
                n--;
            }
        }
        return sb.reverse().toString();
    }
}
