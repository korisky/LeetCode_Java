package Ex1_to_30.Ex28_ImplementstrStr;

public class ImplementStrStr_S {
    public int strStr(String haystack, String needle) {
        if (needle == null || haystack == null || needle == "" || haystack == "")
            return 0;
        int start = 0;
        if (haystack.contains(needle)) {
            StringBuffer sb = new StringBuffer(haystack);
            while (sb.length() >= needle.length()) {
                if (sb.toString().startsWith(needle))
                    break;
                else {
                    sb.delete(0, 1);
                    start++;
                }
            }
        } else
            return -1;
        return start;
    }

    public static void main(String[] args) {
        ImplementStrStr_S use = new ImplementStrStr_S();
        String input = "hello";
        String find = "ll";

        System.out.println(use.strStr(input, find));
    }
}
