package Ex1_to_30.Ex14_LongestCommonPrefix;

/*
Main points:
1. String has a function : startWith.
2. prefix can be check by using one of the String and keep cut it's tail to check
3. Using String.subString would much more faster then keep introducting StringBuffer
 */


public class longestCommonPrefix_Fast {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        StringBuilder pre = new StringBuilder(strs[0]);
        for (String str : strs) {
            while (!str.startsWith(pre.toString())) {
                if (pre.length() == 1)
                    return "";
                pre.delete(pre.length() - 1, pre.length());
            }
        }
        return pre.toString();
    }
}
