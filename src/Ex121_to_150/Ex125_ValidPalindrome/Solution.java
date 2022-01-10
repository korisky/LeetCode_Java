package Ex121_to_150.Ex125_ValidPalindrome;

/**
 * 这题重点在于: String.replaceAll("[^A-Za-z0-9]", "") 这样将所有无关内容替换
 */
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
