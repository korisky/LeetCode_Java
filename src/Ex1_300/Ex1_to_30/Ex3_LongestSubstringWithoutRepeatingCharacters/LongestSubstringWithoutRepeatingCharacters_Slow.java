package Ex1_300.Ex1_to_30.Ex3_LongestSubstringWithoutRepeatingCharacters;

/*
New String method that using StringBuffer to store the substring,
we could use StringBuilder's delete() and append() method to edit the string
without flushing the RAM like the original String type.

Also, we could use SB.indexof("the char I looking for"), if it's
return value is -1, similar to the False of String.contains()
 */

public class LongestSubstringWithoutRepeatingCharacters_Slow {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int max_len = 1;
        StringBuilder temp_str = new StringBuilder(s.substring(0, 1));
        for (int i = 1; i < s.length(); i++) {
            String cur_digit = s.substring(i, i + 1);
            int meet_index = temp_str.indexOf(cur_digit);
            if (meet_index != -1) {     // means repeated char occurred
                temp_str.delete(0, meet_index + 1);
            }
            temp_str.append(cur_digit);
            if (temp_str.length() > max_len){
                max_len = temp_str.length();
            }
        }
        return max_len;
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
