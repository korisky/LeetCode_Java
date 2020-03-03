package Ex1_to_30.Ex9_PalindromeNumber;

/*
remember: for INT number, the fastest way to reverse it, is to % 10 and * 10 stuff.
Using this method can much more faster than convert it into String an reverse.
 */

public class isPalindrome_Fast {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int rev = 0;
        int tempUsing = x;
        while (tempUsing != 0){
            rev = rev * 10 + tempUsing % 10;
            tempUsing /= 10;
        }
        return rev == x;
    }

    public static void main(String[] args) {
        isPalindrome_Fast use = new isPalindrome_Fast();
        System.out.println(use.isPalindrome(-121));
    }
}
