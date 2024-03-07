package Ex1_300.Ex1_to_30.Ex17_LetterCombinationsOfPhoneNumber;

import java.util.ArrayList;
import java.util.List;

/*
IMP:    1. we can get Combination (cartitian product), by using depth-first-search method.
        2. by using StringBuffer, or StringBuilder, add & delete char would be much more
        faster than using String
 */

public class LetterCombinations_Fast {

    private ArrayList<String> combins;
    public static String[] dict = new String[]{"", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return new ArrayList<>();
        combins = new ArrayList<>();
        dfsOnDigits(digits, new StringBuilder());
        return combins;
    }

    public void dfsOnDigits(String input, StringBuilder curComb) {
        if (input.length() == curComb.length()) {
            combins.add(curComb.toString());
            return;
        }
        int curDigit = input.charAt(curComb.length()) - '0';
        for (char c : dict[curDigit].toCharArray()) {
            curComb.append(c);
            dfsOnDigits(input, curComb);
            curComb.deleteCharAt(curComb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations_Fast use = new LetterCombinations_Fast();
        System.out.println(use.letterCombinations("23"));
    }
}
