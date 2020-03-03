package Ex1_to_30.Ex17_LetterCombinationsOfPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {

    private ArrayList<String> combs;
    static HashMap<Character, String> mapping = new HashMap<>();

    {
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        combs = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return combs;

        String[] chS = new String[digits.length()];

        for (int i = 0; i < digits.length(); i++) {
            chS[i] = mapping.get(digits.charAt(i));
        }

        this.cartitianProduct(chS, 0, "");
        return this.combs;
    }

    public void cartitianProduct(String[] strs, int curSlots, String curTempStr) {
        if (curTempStr.length() == strs.length) {
            this.combs.add(curTempStr);
            return;
        } else {
            for (int i = 0; i < strs[curSlots].length(); i++){
                cartitianProduct(strs, curSlots + 1, curTempStr + strs[curSlots].charAt(i));
            }
            return;
        }
    }


    public static void main(String[] args) {
        LetterCombinations use = new LetterCombinations();
        System.out.println(use.letterCombinations("23"));
    }
}
