package Ex601_900.Ex842_SplitArrayintoFibonacciSequence;

import java.util.ArrayList;
import java.util.List;

/*
    Idea from LeetCode, What is the real small step in this recursion problem???
    e.g. we have 1, 2, 3, 4, 4, 6, we should get: 12, 34, 46
    small step would be:
        1. add 1 into res
        2. add 2 into res
        3. add 3 into res and check 1 + 2 == 3, keep going
        4. add 4 into res bur 2 + 3 > 4, we should return FALSE
        5. after getting FALSE, we should pop out 3, 2, and 1
        6. then we try to add 12, instead of 2, and keep trying 3, 34, ....


        The biggest loop would be: String.subString(index, i), keep finding
        long enough i to add into list.
        BUT, if we find: subString1 + subString2 < subString3, then we must break
        which means we must find a longer subString2, then we might possible get
        subString1 + subString2 == subString3
 */


public class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        helper(new StringBuilder(S), 0, res);
        return res;
    }

    public boolean helper(StringBuilder sb, int idx, List<Integer> res) {
        if (idx == sb.length() && res.size() > 2) {
            return true;
        } else {
            for (int i = idx; i < sb.length(); i++) {
                if (sb.charAt(idx) == '0' && i > idx)
                    break; // the break here is the situation:
                // we get 5 first, just break and return false,
                // then in last recursion, 5 will be removed and 50 would be added
                long num = Long.parseLong(sb.substring(idx, i + 1));
                if (num > Integer.MAX_VALUE)
                    break; // criteria from the question
                int size = res.size();
                if (size >= 2 && res.get(size - 1) + res.get(size - 2) < num)
                    break; // if RHS, that means we must break and make last 1
                // or the one before last one bigger. Otherwise, we cannot
                // fit Fibonacci criteria
                if (size <= 1 || res.get(size - 1) + res.get(size - 2) == num) {
                    // size <= 1 means we still have no ele in res, we need to add it no matter what
                    // RHS means it meet the Fibonacci criteria, we should keep going
                    res.add((int)num);
                    if (helper(sb, i + 1, res))
                        return true; // if one possible solution found, we can stop
                    res.remove(res.size() - 1);
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        String test = "1230450";
        use.splitIntoFibonacci(test);
    }
}
