package Ex1_300.Ex1_to_30.Ex9_PalindromeNumber;

public class isPalindrome {
    public boolean isPalindrome(int x) {
        StringBuffer sb = new StringBuffer(String.valueOf(x));
        if (sb.reverse().toString().equals(String.valueOf(x)))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        isPalindrome use = new isPalindrome();
        System.out.println(use.isPalindrome(121));
    }
}
