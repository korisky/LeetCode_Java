package Extras.FlexportPreparing;

import java.util.*;

public class RandomWordSelection {

    public List<String> randomSelect(String sentences, int totalNum) {

        // Step 1: add sentences words into the Location Map
        String[] words = sentences.split(" ");
        Map<String, ArrayList<Integer>> wordLocMap = new HashMap<>();
        for (int idx = 0; idx < words.length; idx++) {
            ArrayList<Integer> curLocs = wordLocMap.getOrDefault(words[idx], new ArrayList<>());
            curLocs.add(idx);
            wordLocMap.put(words[idx], curLocs);
        }

        // Step 2: randomly choose the first words, then keep going
        Random rand = new Random();
        int wordIdx = rand.nextInt(words.length);
        List<String> result = new ArrayList<>();

        while (result.size() < totalNum) {
            // add curWords
            result.add(words[wordIdx]);
            // for nextWord, find it's locations
            wordIdx = (wordIdx == words.length - 1) ? 0 : wordIdx + 1;
            // randomly pic this next word's loc
            ArrayList<Integer> locs = wordLocMap.get(words[wordIdx]);
            int locChoose = rand.nextInt(locs.size());
            wordIdx = locs.get(locChoose);
        }

        return result;
    }

    public static void main(String[] args) {
        RandomWordSelection test = new RandomWordSelection();

        String s = "hello this is a flexport interview and this is a hello and that was cool";

        for (int i = 0; i < 50; i++) {
            List<String> strings = test.randomSelect(s, 5);
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }

    }
}
