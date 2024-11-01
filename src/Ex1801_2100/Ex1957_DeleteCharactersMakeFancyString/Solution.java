package Ex1801_2100.Ex1957_DeleteCharactersMakeFancyString;

public class Solution {

    public static String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char last = '0';
        for (char c : s.toCharArray()) {
            if (last != c) {
                last = c;
                count = 1;
                sb.append(c);
            } else if (count < 2) {
                count++;
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeFancyString("leeetcode"));
    }
}
