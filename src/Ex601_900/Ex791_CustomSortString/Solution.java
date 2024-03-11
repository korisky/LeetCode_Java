package Ex601_900.Ex791_CustomSortString;

public class Solution {

    public static String customSortString(String order, String s) {
        // 1. 拆分char数组
        char[] orderArr = order.toCharArray();
        char[] targetArr = s.toCharArray();
        // 2. 统计s中的字母频率
        int[] targetFreq = new int[26];
        for (char c : targetArr) {
            targetFreq[c - 'a']++;
        }
        // 3. 遍历order, 并结合频率, 进行结果组装
        StringBuilder sb = new StringBuilder();
        for (char c : orderArr) {
            while (targetFreq[c - 'a'] > 0) {
                sb.append(c);
                targetFreq[c - 'a']--;
            }
        }
        // 4. 针对order没有的值, 按照字母顺序填补
        for (int i = 0; i < targetFreq.length; i++) {
            while (targetFreq[i] > 0) {
                sb.append((char) ('a' + i));
                targetFreq[i]--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(customSortString("cbag", "abcdddzsg"));
    }
}
