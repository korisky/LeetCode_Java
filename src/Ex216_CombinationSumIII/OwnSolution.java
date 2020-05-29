package Ex216_CombinationSumIII;

/*
    Combination Sum I: get unique combination (each number can only be used once) to obtain that specific target
    Combination Sum II: get unique combination (each number can be used several times) to obtain specific target
    Combination Sum III: from 1 - k, do the Combination Sum I.
 */

import java.util.ArrayList;
import java.util.List;

public class OwnSolution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        dfsComb(0, 8, n, k, new ArrayList<>(), results);
        return results;
    }

    public void dfsComb(int start, int end, int target, int depthRemain,
                        ArrayList<Integer> curComb, List<List<Integer>> results) {

        if (target == 0 && depthRemain == 0) {
            results.add(new ArrayList<>(curComb));
        } else if (target > 0 && depthRemain > 0) {
            for (int curIndex = start; curIndex <= end; curIndex++) {
                if (curIndex + 1 > target)
                    break; // cause we store them increasingly
                curComb.add(curIndex + 1);
                dfsComb(curIndex + 1, end,
                        target - curIndex - 1, depthRemain - 1, curComb, results);
                curComb.remove(curComb.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        OwnSolution use = new OwnSolution();
        System.out.println(use.combinationSum3(3, 9));
    }
}
