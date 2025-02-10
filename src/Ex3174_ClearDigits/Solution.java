package Ex3174_ClearDigits;

public class Solution {

    public String clearDigits(String s) {

        int resultLen = 0;
        char[] charArray = s.toCharArray();

        for (int charIdx = 0; charIdx < s.length(); charIdx++) {
            if (Character.isDigit(s.charAt(charIdx))) {
                resultLen = Math.max(resultLen - 1, 0);
            } else {
                charArray[resultLen++] = s.charAt(charIdx);
            }
        }

        return new String(charArray, 0, resultLen);
    }
}
