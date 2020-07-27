package Ex125_ValidPalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        String cut = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuilder(cut).reverse().toString();
        return cut.equals(rev);
    }

    public static void main(String[] args) {
        String test = "A man, a plan, a canal: Panama";
        String actual = test.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println(test);
        System.out.println(actual); // amanaplanacanalpanama
    }
}
