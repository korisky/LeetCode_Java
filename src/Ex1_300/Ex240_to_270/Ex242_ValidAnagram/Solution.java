package Ex1_300.Ex240_to_270.Ex242_ValidAnagram;

public class Solution {
    public boolean isAnagram(String s, String t) {

        if (s == null || t == null || s.length() != t.length())
            return false;

        int[] freqS = new int[26];
        int[] freqT = new int[26];

        char[] strS = s.toCharArray();
        char[] strT = t.toCharArray();

        for (int i = 0; i < strS.length; i++) {
            freqS[strS[i] - 'a']++;
            freqT[strT[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++){
            if (freqS[i] != freqT[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        String s1 = "anagram";
        String s2 = "nagaram";
        System.out.println(use.isAnagram(s1, s2));
    }
}
