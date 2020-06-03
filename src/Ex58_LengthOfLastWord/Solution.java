package Ex58_LengthOfLastWord;

public class Solution {
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        String s = "  Hello World ";
        System.out.println(use.lengthOfLastWord(s));
    }
}
