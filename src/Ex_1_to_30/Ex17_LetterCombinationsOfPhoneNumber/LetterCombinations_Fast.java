package Ex_1_to_30.Ex17_LetterCombinationsOfPhoneNumber;

import java.util.ArrayList;
import java.util.List;

/*
IMP:    1. we can get Combination (cartitian product), by using depth-first-search method.
        2. by using StringBuffer, or StringBuilder, add & delete char would be much more
        faster than using String
 */

public class LetterCombinations_Fast {

    private ArrayList<String> combs;
    public static String[] dict = new String[]{"abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        combs = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return combs;
        char[] digitArr = digits.toCharArray();
        dfsOnDigits(digitArr, 0, new StringBuffer());
        return combs;
    }

    public void dfsOnDigits(char[] digits, int curSlot, StringBuffer partComb) {
        if (partComb.length() == digits.length){
            combs.add(partComb.toString());
            return;
        }
        String curChoices = dict[Character.getNumericValue(digits[curSlot]) - 2];
        for (char val : curChoices.toCharArray()){
            partComb.append(val);
            dfsOnDigits(digits, curSlot + 1, partComb);
            partComb.deleteCharAt(partComb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations_Fast use = new LetterCombinations_Fast();
        System.out.println(use.letterCombinations("23"));
    }
}
