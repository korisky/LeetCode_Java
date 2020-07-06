package Ex31_to_60.Ex47_Permutations2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OwnSolution {
    /*
        Might have repeat numbers
     */

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        // count the frequency
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int number : nums)
            freqMap.put(number, freqMap.getOrDefault(number, 0) + 1);

        int[][] numFreqArr = new int[freqMap.keySet().size()][2];
        int start = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            numFreqArr[start][0] = entry.getKey();
            numFreqArr[start][1] = entry.getValue();
            start++;
        }

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        getPermutations(nums.length, numFreqArr, tempList, results);
        return results;
    }


    public void getPermutations(int permuteLen, int[][] numFreqArr,
                                List<Integer> tempList, List<List<Integer>> results) {

        if (tempList.size() == permuteLen) {
            results.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < numFreqArr.length; i++) {
                if (numFreqArr[i][1] == 0)
                    continue;
                numFreqArr[i][1]--;
                tempList.add(numFreqArr[i][0]);
                getPermutations(permuteLen, numFreqArr, tempList, results);
                tempList.remove(tempList.size() - 1);
                numFreqArr[i][1]++;
            }
        }
    }


    public static void main(String[] args) {
        OwnSolution use = new OwnSolution();
        int[] test = new int[]{1, 1, 2};
        System.out.println(use.permuteUnique(test));
    }
}
