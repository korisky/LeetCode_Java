package Extras;

public class OnlineTest {

    public static String transform(String input) {

        if (null == input || "".equals(input)) {
            return "";
        }

        char[] chars = input.toCharArray();
        char last = chars[0];

        StringBuilder sb = new StringBuilder();
        sb.append(last);

        for (int i = 1; i < chars.length; i++) {
            if (last != chars[i]) {
                last = chars[i];
                sb.append(last);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(transform("abbcbbb"));
        System.out.println(transform(""));
        System.out.println(transform("aaaaaa"));
        System.out.println(transform("baaaaaa"));
        System.out.println(transform("aaaaaac"));
        System.out.println(transform("baaaaaac"));
    }


}
