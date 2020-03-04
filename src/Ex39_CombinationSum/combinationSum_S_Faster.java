package Ex39_CombinationSum;

import java.util.ArrayList;
import java.util.List;


/*
Instead of using a global variable, and add stuff for it in function, we just
pass it as an argument would become a little bit faster
 */

public class combinationSum_S_Faster {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) ;
        else {
            findPossibleComb(candidates, 0, results, target, new ArrayList<>());
        }
        return results;
    }

    public void findPossibleComb(int[] candidates, int start, List<List<Integer>> results, int target, ArrayList<Integer> curComb) {
        if (target == 0) {
            results.add(new ArrayList<>(curComb));
            return;
        }
        if (target < 0)
            return;
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target)
                continue;
            curComb.add(candidates[i]);
            findPossibleComb(candidates, i, results, target - candidates[i], curComb);
            curComb.remove(curComb.size() - 1);
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
