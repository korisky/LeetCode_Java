package Ex61_to_90.Ex77_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        getAllComb(results, new int[k], 0, n - 1, 0);
        return results;
    }

    public void getAllComb(List<List<Integer>> results, int[] eachComb, int start, int end, int index) {
        if (index == eachComb.length) {
            List<Integer> curComb = new ArrayList<>();
            for (int num : eachComb)
                curComb.add(num);
            results.add(curComb);
        } else if (start <= end) {
            eachComb[index] = start + 1;
            getAllComb(results, eachComb, start + 1, end, index + 1);
            getAllComb(results, eachComb, start + 1, end, index); // here is about 'COVER' the last ele we add
        }
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        System.out.println(use.combine(3, 2));
    }
}
