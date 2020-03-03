package Ex1_to_30.Ex3_LongestSubstringWithoutRepeatingCharacters;

public class LongestSubstringWithoutRepeatingCharacters_Slow {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        String tempStr = s.substring(0, 1);
        int maxLen = 1;
        for (int i = 1; i < s.length(); i++) {
            if (tempStr.contains(s.substring(i, i + 1))) {
                int index = tempStr.indexOf(s.substring(i, i + 1));
                tempStr = tempStr.substring(index + 1);
            }
            tempStr += "" + s.substring(i, i + 1);
            if (tempStr.length() > maxLen) {
                maxLen = tempStr.length();
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters_Slow use = new LongestSubstringWithoutRepeatingCharacters_Slow();
        String test = "asdbasbuiabweibiuebfleuaksfkjsdbkcjbkjcbkbkzxckSBKDCBKsbduiqwsakdsakdhasjkdhkjasdhjkasdhjksadhjkadhjkasdjkhasjkdhasjkdhjkasdhasjkdhas";

        long startTime = System.currentTimeMillis();
        System.out.println(use.lengthOfLongestSubstring(test));
        long endTime = System.currentTimeMillis();
        System.out.println("Program Running Time：" + (endTime - startTime) + "ms");
    }
}
