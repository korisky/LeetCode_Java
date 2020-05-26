package Ex39_CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
Instead of using a global variable, and add stuff for it in function, we just
pass it as an argument would become a little bit faster
 */

public class combinationSum_S_Faster {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        findPossibleComb(candidates, 0, results, target, new ArrayList<>());
        return results;
    }

    public void findPossibleComb(int[] candidates, int start,
                                 List<List<Integer>> results, int target, ArrayList<Integer> curComb) {
        if (target == 0) {
            results.add(new ArrayList<>(curComb));
        } else if (target > 0) {
            for (int curIndex = start; curIndex < candidates.length; curIndex++) {
                if (candidates[curIndex] > target)
                    continue;
                curComb.add(candidates[curIndex]);
                findPossibleComb(candidates, curIndex, results, // here startIndex become curIndex, then we
                                                                // can eliminate duplicated numbers.
                        target - candidates[curIndex], curComb);
                curComb.remove(curComb.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        combinationSum_S_Faster use = new combinationSum_S_Faster();
        int[] test = new int[]{2, 3, 5};
        List<List<Integer>> result = use.combinationSum(test, 8);
        for (List<Integer> curList : result) {
            System.out.println(curList.toString());
        }
    }
}
