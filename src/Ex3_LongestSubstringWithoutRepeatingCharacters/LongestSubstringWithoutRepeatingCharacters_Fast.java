package Ex3_LongestSubstringWithoutRepeatingCharacters;

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
