package Ex1_to_30.Ex28_ImplementstrStr;

public class ImplementStrStr_S_FAST {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        ImplementStrStr_S_FAST use = new ImplementStrStr_S_FAST();
        String input = "hello";
        String find = "ll";

        System.out.println(use.strStr(input, find));
    }
}
