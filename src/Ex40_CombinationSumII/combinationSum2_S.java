package Ex40_CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2_S {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) ;
        else {
            Arrays.sort(candidates);
            findPossibleComb2(candidates, 0, results, target, new ArrayList<>());
        }
        return results;
    }

    public void findPossibleComb2(int[] candidates, int start, List<List<Integer>> results, int target, ArrayList<Integer> curComb) {
        if (target == 0) {
            results.add(new ArrayList<>(curComb));
            return;
        }
        if (target < 0)
            return;
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target)
                break;
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            curComb.add(candidates[i]);
            findPossibleComb2(candidates, i + 1, results, target - candidates[i], curComb);
            curComb.remove(curComb.size() - 1);
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
