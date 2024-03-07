package Ex1_300.Ex1_to_30.Ex5_LongestPalindromicSubstring;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class longestPalindrome_Fast {
    public String longestPalindrome(String s) {

        if (s == null || s.length() <= 1)
            return s;

        // Manacher's Algorithm
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder("#");
        for (char c : arr) {
            sb.append(c);
            sb.append("#");
        }

        int centre = 0;
        int right_boundary = 0;
        int max_len = 0;
        int max_centre = 0;
        int[] palin_len = new int[sb.length()];

        for (int i = 0; i < sb.length() - 1; i++) { // sb[sb.length() - 1] is #, we do not need to check it
            int mirror = 2 * centre - i; // mirror position got at least it's mirror's length

            if (i < right_boundary)
                palin_len[i] = Math.min(right_boundary - i, palin_len[mirror]);
                // according to Manacher's Algorithm's Graph.....

            while (i - palin_len[i] - 1 >= 0 && i + palin_len[i] + 1 < sb.length() // Careful here! its < not <=
                    && sb.charAt(i - palin_len[i] - 1) == sb.charAt(i + palin_len[i] + 1))
                palin_len[i]++;
                // keep expending the palindrome

            if (i + palin_len[i] > right_boundary) {
                // re-direct the centre (cause it has longer palindrome)
                centre = i;
                right_boundary = i + palin_len[i];
                if (palin_len[i] > max_len) {
                    max_centre = i;
                    max_len = palin_len[i];
                }
            }
        }

        // Here we use Pattern and Matcher to do character replacement in StringBuffer
        // Which is much more faster then doing .replaceAll() with String.
        Pattern p = Pattern.compile("#");
        Matcher m = p.matcher(sb.substring(max_centre - max_len, max_centre + max_len));
        StringBuffer  result = new StringBuffer ();
        while (m.find()){
            m.appendReplacement(result, "");
        }
        m.appendTail(result);
        return result.toString();
    }

    public static void main(String[] args) {
        longestPalindrome_Fast use = new longestPalindrome_Fast();
        System.out.println(use.longestPalindrome("babad"));
    }
}
