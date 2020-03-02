package Ex_1_to_30.Ex14_LongestCommonPrefix;

/*
Main points:
1. String has a function : startWith.
2. prefix can be check by using one of the String and keep cut it's tail to check
3. Using String.subString would much more faster then keep introducting StringBuffer
 */


public class longestCommonPrefix_Fast {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null)
            return "";
        if (strs.length == 1)
            return strs[0];

        String preFix = strs[0];
        for (String str: strs){
            while (!str.startsWith(preFix)){
                if (preFix.length() == 1)
                    return "";
                preFix = preFix.substring(0, preFix.length() - 1);
            }
        }
        return preFix;
    }
}
