package Ex_1_to_30.Ex5_LongestPalindromicSubstring;

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
