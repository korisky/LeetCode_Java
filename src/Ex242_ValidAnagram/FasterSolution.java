package Ex242_ValidAnagram;

/*
    Instead of counting all two string's characters' frequency, we just count one of them
    Then use it to DECREASE, if a single slot become < 0, they must be different.
 */

public class FasterSolution {
    public boolean isAnagram(String s, String t) {

        if (s == null || t == null || s.length() != t.length())
            return false;

        int[] sFrequency = new int[26];
        for (char c : s.toCharArray())
            sFrequency[c - 'a']++;

        for (char c : t.toCharArray()){
            sFrequency[c - 'a']--;
            if (sFrequency[c - 'a'] < 0)
                return false;
        }

        return true;
    }
}
