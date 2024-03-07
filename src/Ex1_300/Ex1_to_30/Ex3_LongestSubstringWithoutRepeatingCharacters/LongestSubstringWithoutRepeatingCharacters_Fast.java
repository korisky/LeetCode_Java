package Ex1_300.Ex1_to_30.Ex3_LongestSubstringWithoutRepeatingCharacters;

/*
Here the fast implementation's method is about traverse the char[],
each time, we store a 'left' pointer, to store current unrepeated-string's start point,
each iteration (traversing char[]), we start traverse from 'left' to the one before current
tail. By using this INSIDE LOOPS, would faster than using CONTAINS in String. BUT, in Python,
Using CONTAINS would be the fastest method.
 */

public class LongestSubstringWithoutRepeatingCharacters_Fast {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        char[] charStr = s.toCharArray();
        int maxLen = 0;
        int left = 0;
        int checker = 0;

        for (int j = 0; j < charStr.length; j++){
            for (checker = left; checker < j; checker++){
                if (charStr[checker] == charStr[j]){
                    maxLen = Math.max(maxLen, j - left);
                    left = checker + 1;
                }
            }
        }

        return Math.max(maxLen, charStr.length - left);
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters_Fast use = new LongestSubstringWithoutRepeatingCharacters_Fast();
        String test = "asdbasbuiabweibiuebfleuaksfkjsdbkcjbkjcbkbkzxckSBKDCBKsbduiqwsakdsakdhasjkdhkjasdhjkasdhjksadhjkadhjkasdjkhasjkdhasjkdhjkasdhasjkdhas";

        long startTime = System.currentTimeMillis();
        System.out.println(use.lengthOfLongestSubstring(test));
        long endTime = System.currentTimeMillis();
        System.out.println("Program Running Time：" + (endTime - startTime) + "ms");
    }
}
