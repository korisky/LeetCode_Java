package Ex1_to_30.Ex30_SubstringWithConcatenationOfAllWords;

import java.util.*;

public class findSubstring_S {

    private ArrayList<String> allComb;
    public List<Integer> findSubstring(String s, String[] words) {
        LinkedHashSet<Integer> store = new LinkedHashSet<>();
        if (s == null || words == null || words.length == 0 || s.length() == 0 || s == "")
            return new ArrayList<>();

        // 1. get all possible permutations of words
        allComb = new ArrayList<>();
        List<String> input = Arrays.asList(words);
        getStrPermutations(input, 0, input.size() - 1);

        // 2. check all index that contains the permutations
        for (String str : allComb) {
            for (int i = 0; i < s.length();) {
                int index = s.indexOf(str, i);
                if (index == -1)
                    break;
                else {
                    store.add(index);
                    i = index + 1;
                }
            }
        }
        return new ArrayList<>(store);
    }

    public void getStrPermutations(List<String> words, int left, int right) {
        if (left == right) {
            String onePermu = "";
            for (String str : words)
                onePermu += str;
            allComb.add(onePermu);
        } else {
            for (int i = left; i <= right; i++) {
                Collections.swap(words, left, i);
                getStrPermutations(words, left + 1, right);
                Collections.swap(words, i, left);
            }
        }
    }


    public static void main(String[] args) {
        findSubstring_S use = new findSubstring_S();
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","good"};
        List<Integer> result = use.findSubstring(s, words);
        for (int i : result)
            System.out.println(i);
    }
}
