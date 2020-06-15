package Ex567_PermutationInString;

/*
    For this question, we can use a frequency array like this:
        1) for the string that is our target, we add 1 to this current char's frequency
        2) for the string that is finding the target, we minus 1 to this current char's frequency.

    After we traverse the target string, we need to still go through the finding string
        1) start from the targetStringLen + 1, we should - 1 for that specific char's frequency
        2) then start from the index 0, we should + 1 for that specific char's frequency

    Once we find out, the frequency array is all 0, that means we find out the one.
 */

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2)
            return false;

        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        int[] freArr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freArr[s1Chars[i] - 'a']++;
            freArr[s2Chars[i] - 'a']--;
        }

        if (allZero(freArr))
            return true;

        for (int idx = len1; idx < len2; idx++) {
            freArr[s2Chars[idx] - 'a']--;
            freArr[s2Chars[idx - len1] - 'a']++;
            if (allZero(freArr))
                return true;
        }
        return false;
    }


    public boolean allZero(int[] nums) {
        for (int i : nums) {
            if (i != 0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution use = new Solution();
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(use.checkInclusion(s1, s2));
    }
}
