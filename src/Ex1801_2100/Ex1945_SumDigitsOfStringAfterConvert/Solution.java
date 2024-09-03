package Ex1801_2100.Ex1945_SumDigitsOfStringAfterConvert;

public class Solution {

    public static int getLucky(String s, int k) {
        // convert to digit
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 96);
        }
        String result = sb.toString();
        while (k-- > 0) {
            result = transfrom(result);
        }
        return Integer.parseInt(result);
    }

    private static String transfrom(String input) {
        long tmp = 0;
        for (char c : input.toCharArray()) {
            tmp += Character.getNumericValue(c);
        }
        return String.valueOf(tmp);
    }


    public static void main(String[] args) {
//        System.out.println('i' - 96);
//        System.out.println(getLucky("iiii", 1));
//        System.out.println(getLucky("leetcode", 2));
//        System.out.println(getLucky("zbax", 2));
        System.out.println(getLucky("dbvmfhnttvr", 5));
    }
}
