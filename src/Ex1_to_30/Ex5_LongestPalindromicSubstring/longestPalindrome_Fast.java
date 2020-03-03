package Ex1_to_30.Ex5_LongestPalindromicSubstring;

public class longestPalindrome_Fast {
    public String longestPalindrome(String s) {
        char[] sArr = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        sb.append("#");
        for (int i = 0; i < sArr.length; i++) {
            sb.append(sArr[i]);
            sb.append("#");
        }
        int[] lenArr = new int[sb.length()];

        // Manacher's Algorithm
        int centre = 0;
        int rightBound = 0;
        int maxLength = 0;
        int realCentre = 0;
        for (int i = 0; i < sb.length() - 1; i++) { // sb[sb.length() - 1] is #, we do not need to check it
            int mirror = 2 * centre - i;
            // mirror position got at least it's mirror's length
            if (i < rightBound)
                lenArr[i] = Math.min(lenArr[mirror], rightBound - i);
                // according to Manacher's Algorithm's Graph.....
            while ( i - lenArr[i] - 1 >= 0 && i + lenArr[i] + 1 < sb.length()
                    && sb.charAt(i + lenArr[i] + 1) == sb.charAt(i - lenArr[i] - 1))
                lenArr[i]++; // keep expending the palindrome
            if (i + lenArr[i] > rightBound){
                centre = i; // re-direct the centre (cause it has longer palindrome)
                rightBound = i + lenArr[i];
                if (maxLength < lenArr[i]){
                    maxLength = lenArr[i];
                    realCentre = i;
                }

            }
        }
        char[] ret = sb.subSequence(realCentre - maxLength, realCentre + maxLength).toString().toCharArray();
        String result = "";
        for (int i = 0; i < ret.length; i++){
            if (ret[i] != '#')
                result += ret[i];
        }
        return result;
    }

    public static void main(String[] args) {
        longestPalindrome_Fast use = new longestPalindrome_Fast();
        System.out.println(use.longestPalindrome("babad"));
    }
}
