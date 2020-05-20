package Ex1_to_30.Ex3_LongestSubstringWithoutRepeatingCharacters;

/*

 */

public class LongestSubstringWithoutRepeatingCharacters_ExtremeFast {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int[] digit_index = new int[128]; // using an array to store from a-z A-Z's digits' latest meeting index
        int start = 0;
        int end = 0;
        int result = 0; // store the longest result
        char cur_digit;

        while(end < s.length()){
            cur_digit = s.charAt(end);
            start = Math.max(start, digit_index[cur_digit]); // Here can be considered, each time we
                                                    // calculate the latest substring's length is from right
                                                    // to left. Two situations would occur:
                                                    // 1. "abc" , cur_digit = 'c', left = 'a', then
                                                    // we get length from (CUR_INDEX - LEFT + 1 = 3)
                                                    // 2. "abcb", cur_digit = 'b', left = 'a', then
                                                    // we get length from (CUR_INDEX - LAST b's INDEX + 1 = 2 )
            result = Math.max(result, end - start + 1);
            digit_index[cur_digit] = end + 1; // here can be seen as, e.g. "bacb", cur_digit = 'b',
                                            // this can be considered as: next time when we use this latest index
                                            // of a specific digit, which means we are POINTING to that same digit
                                            // again, we must CUT one of them (e.g. "abca", we should get length 3,
                                            // instead of 4 - 0 = 4, we get 3 by: 4 - (0 + 1) = 3)
            end++;
        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters_ExtremeFast use = new LongestSubstringWithoutRepeatingCharacters_ExtremeFast();
        String test = "asdbasbuiabweibiuebfleuaksfkjsdbkcjbkjcbkbkzxckSBKDCBKsbduiqwsakdsakdhasjkdhkjasdhjkasdhjksadhjkadhjkasdjkhasjkdhasjkdhjkasdhasjkdhas";

        long startTime = System.currentTimeMillis();
        System.out.println(use.lengthOfLongestSubstring(test));
        long endTime = System.currentTimeMillis();
        System.out.println("Program Running Time：" + (endTime - startTime) + "ms");
    }
}
