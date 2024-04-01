package Ex1_300.Ex31_to_60.Ex58_LengthOfLastWord;

public class Solution {
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }

    public int lengthOfLastWord_StringBuilder(String s) {
        char[] charArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = charArr.length - 1; i >= 0; i--) {
            char c = charArr[i];
            if (c != ' ') sb.append(c);
            if (c == ' ' && !sb.isEmpty()) break;
        }
        return sb.length();
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        String s = "  Hello World ";
        System.out.println(use.lengthOfLastWord(s));
    }
}
