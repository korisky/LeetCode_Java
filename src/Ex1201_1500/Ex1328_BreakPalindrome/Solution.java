package Ex1201_1500.Ex1328_BreakPalindrome;

/**
 * The solution is:
 * 1. go through the half of the input palindrome string
 * 2. if the character is not 'a', replace it into a
 * 3. if the character is 'a', try to replace it to 'a'
 * 4. if we replace nothing, means even the middle slot is 'a', then we replace the last one to 'b'
 */
class Solution {

    public String breakPalindrome(String palindrome) {

        if (null == palindrome || palindrome.length() < 2) {
            return "";
        }

        char[] charArray = palindrome.toCharArray();
        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != 'a') {
                charArray[i] = 'a';
                return String.valueOf(charArray);
            }
        }

        charArray[charArray.length - 1] = 'b';
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String answer = solution.breakPalindrome("abccba");
        System.out.println(answer);
    }

}
