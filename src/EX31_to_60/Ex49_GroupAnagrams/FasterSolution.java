package EX31_to_60.Ex49_GroupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/*
    Method from LeetCode: using a set of 26 PRIME NUMBER,
    Instead of counting the frequency of all 26 characters, we use
    the original String to directly HASHCODE
 */

public class FasterSolution {
    private int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61, 67,
            71, 73, 79, 83, 89, 97, 101};

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> theMap = new HashMap<>();
        for (String s : strs) {
            int hashCode = hash(s);
            if (!theMap.containsKey(hashCode))
                theMap.put(hashCode, new ArrayList<>());
            theMap.get(hashCode).add(s);
        }
        return new ArrayList<>(theMap.values());
    }

    private int hash(String s) {
        int sum = 1;
        for (char c : s.toCharArray())
            sum *= primes[c - 'a'];
        return sum;
    }

    public static void main(String[] args) {
        String[] test = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        FasterSolution use = new FasterSolution();
        System.out.println(use.groupAnagrams(test));
    }
}
