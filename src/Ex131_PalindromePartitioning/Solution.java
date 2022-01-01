package Ex131_PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<String>> resultList;
    ArrayList<String> currList;

    public List<List<String>> partition(String s) {
        resultList = new ArrayList<>();
        currList = new ArrayList<>();
        backTrack(s, 0);
        return resultList;
    }

    private void backTrack(String s, int l) {
        if (currList.size() > 0 && l >= s.length()) {
            List<String> cloneList = (List<String>) currList.clone();
            resultList.add(cloneList);
        }

        for (int i = l; i < s.length(); i++) {
            if (isPalindrome(s, l, i)) {
                if (l == i) {
                    currList.add(String.valueOf(s.charAt(i)));
                } else {
                    currList.add(s.substring(l, i + 1));
                }
                backTrack(s, i + 1);
                currList.remove(currList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int l, int r) {
        if (l == r) {
            return true;
        }
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String input = "aab";
        List<List<String>> partition = s.partition(input);
        for (List<String> strings : partition) {
            for (String string : strings) {
                System.out.print(" " + string);
            }
            System.out.println();
        }
    }
}
