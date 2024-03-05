package Ex1750_MinimumLenStringAfterDeletingSimilar;

/**
 * 题目目标是, 双向进行缩减, 如果当前string头部是aa, 尾部是a, 那么进行同时缩减
 * e.g. aabccabca, -> bccabc
 */
public class Solution {

    public int minimumLength(String s) {
        // 双向缩减
        char[] charArray = s.toCharArray();
        int l = 0, r = charArray.length - 1;
        // 若当前最低位和最高位的字符相同, 才可以继续
        while (l < r && charArray[l] == charArray[r]) {
            // 确认当前重复的字符
            char repeatChar = s.charAt(l);
            // 如果低位字符相同, 持续递增
            while (l <= r && charArray[l] == repeatChar) {
                l++;
            }
            // 如果高位字符相同, 持续递减
            while (l <= r && charArray[r] == repeatChar) {
                r--;
            }
        }
        // 返回的是最后缩减的长度
        return l > r ? 0 : (r - l + 1);
    }
}
