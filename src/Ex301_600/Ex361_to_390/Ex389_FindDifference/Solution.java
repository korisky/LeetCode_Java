package Ex301_600.Ex361_to_390.Ex389_FindDifference;

/**
 * 使用异或处理
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        int len = s.length();
        char c = t.charAt(len);
        for (int idx = 0; idx < len; idx++) {
            c ^= s.charAt(idx) ^ t.charAt(idx);
        }
        return c;
    }
}
