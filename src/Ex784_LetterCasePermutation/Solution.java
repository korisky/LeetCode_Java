package Ex784_LetterCasePermutation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCasePermutation(String S) {
        if (S == null || S.length() == 0)
            return new ArrayList<>();
        List<String> res = new ArrayList<>();
        helper(S.toLowerCase().toCharArray(), 0, res);
        return res;
    }

    public void helper(char[] temp, int idx, List<String> res) {
        res.add(new String(temp));
        for (int i = idx; i < temp.length; i++) {
            char curChar = temp[i];
            if (Character.isLetter(curChar)) {
                temp[i] = Character.toUpperCase(curChar);
                helper(temp, i + 1, res);
                temp[i] = curChar;
            }
        }
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        String test = "C2a3z";
        List<String> res = use.letterCasePermutation(test);
        System.out.println(res.toString());
    }
}
