package Ex1_to_30.Ex5_LongestPalindromicSubstring;

/**
 * 最长回文子串的实现要点:
 * 1. 首先所有单个的字符也是回文, 所以dp的对角线全部设置1
 * 2. 遍历String, 如果str[i] == str[i+1], 则dp的dp[i][i+1]要设置也为1
 * 3. 设置curLen = 3, 因为有首尾的回文 e.g. aba, 最小长度是3
 * 4. 当最小长度小于等于输入String的长度时, 进行循环增长
 *  4.1 从左往右, 让 i < String.len - curLen + 1,
 *      随后让 j = i + curLen - 1,
 *      当Str[i] == Str[j] 符合回文要求, 并且 dp[i + 1][j - 1] == 1 它们之间的是回文的时候, 将其设置也为1
 */
public class longestPalindrome_DP {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return s;
        char[] sArr = s.toCharArray();
        int[][] table = new int[sArr.length][sArr.length];
        int maxLength = 1;
        int startIndex = 0;
        for (int i = 0; i < table.length; i++) {
            table[i][i] = 1; // one single character is also a palindrome
            startIndex = i;
        }
        for (int i = 0; i < sArr.length - 1; i++) {
            if (sArr[i] == sArr[i + 1]) {
                table[i][i + 1] = 1; // e.g. "bb" is also a palindrome
                maxLength = 2;
                startIndex = i;
            }
        }
        int curLenP = 3;
        while (curLenP <= s.length()) { // from length of 3, we keep find increasing length palidrome
            for (int i = 0; i < sArr.length - curLenP + 1; i++) {
                int j = i + curLenP - 1;
                if (sArr[i] == sArr[j] && table[i + 1][j - 1] == 1) {
                    table[i][j] = 1;
                    if (maxLength < curLenP) {
                        startIndex = i;
                        maxLength = curLenP;
                    }
                }
            }
            curLenP++;
        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    public static void main(String[] args) {
        longestPalindrome_DP use = new longestPalindrome_DP();
        System.out.println(use.longestPalindrome("aaaa"));
    }
}
