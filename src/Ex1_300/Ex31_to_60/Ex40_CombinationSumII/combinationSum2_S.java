package Ex1_300.Ex31_to_60.Ex40_CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2_S {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        findPossibleComb2(candidates, 0, results, target, new ArrayList<>());
        return results;
    }

    public void findPossibleComb2(int[] candidates, int start,
                                  List<List<Integer>> results, int target, ArrayList<Integer> curComb) {
        if (target == 0) {
            results.add(new ArrayList<>(curComb));
        } else if (target > 0) {
            for (int curIndex = start; curIndex < candidates.length; curIndex++) {
                if (candidates[curIndex] > target)
                    break;
                if (curIndex > start && candidates[curIndex] == candidates[curIndex - 1])
                    continue;
                curComb.add(candidates[curIndex]);
                // difference from the Ex39, in this question, each number can be used exactly once
                // thus, we use curIndex + 1 instead of curIndex
                findPossibleComb2(candidates, curIndex + 1, results, target - candidates[curIndex], curComb);
                curComb.remove(curComb.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        combinationSum2_S use = new combinationSum2_S();
        int[] test = new int[]{10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> result = use.combinationSum2(test, 8);
        for (List<Integer> curList : result) {
            System.out.println(curList.toString());
        }
    }
}
