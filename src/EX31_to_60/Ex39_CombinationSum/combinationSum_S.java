package EX31_to_60.Ex39_CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class combinationSum_S {
    private static List<List<Integer>> results;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) ;

        else {
            findPossibleComb(candidates, 0, target, new ArrayList<>());
        }

        return results;
    }

    public void findPossibleComb(int[] candidates, int start, int target, ArrayList<Integer> curComb) {
        if (target == 0) {
            results.add(new ArrayList<>(curComb));
            return;
        }
        if (target < 0)
            return;
        for (int i = start; i < candidates.length; i++) {
            curComb.add(candidates[i]);
            findPossibleComb(candidates, i, target - candidates[i], curComb);
            curComb.remove(curComb.size() - 1);
        }
        return;
    }

    public static void main(String[] args) {
        combinationSum_S use = new combinationSum_S();
        int[] test = new int[]{2, 3, 5};
        List<List<Integer>> result = use.combinationSum(test, 8);
        for (List<Integer> curList : result) {
            System.out.println(curList.toString());
        }
    }
}
