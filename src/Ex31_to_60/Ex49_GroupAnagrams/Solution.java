package Ex31_to_60.Ex49_GroupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    Using Own idea from Ex242_Solution:
 */

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> theMap = new HashMap<>();
        for (String s : strs) {
            char[] curFreq = new char[26]; // if we use int array here, it would let below
                                        // String.valueOf() not working
            for (char c : s.toCharArray())
                curFreq[c - 'a']++;
            String theKey = String.valueOf(curFreq);
            if (!theMap.containsKey(theKey))
                theMap.put(theKey, new ArrayList<>());
            theMap.get(theKey).add(s);
        }
        return new ArrayList<>(theMap.values());
    }

    public static void main(String[] args) {
        String[] test = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution use = new Solution();
        System.out.println(use.groupAnagrams(test));
    }
}
