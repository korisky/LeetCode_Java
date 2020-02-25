package Ex14_LongestCommonPrefix;

public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null)
            return "";
        if (strs.length == 1)
            return strs[0];

        int minLen = 100000;
        for (int i = 0; i < strs.length; i++){
            if (strs[i].length() < minLen){
                minLen = strs[i].length();
            }
        }

        StringBuffer preFix = new StringBuffer();
        for (int chNum = 0; chNum < minLen; chNum++){
            char curChar = strs[0].charAt(chNum);
            for (int row = 1; row < strs.length; row++){
                if (curChar != strs[row].charAt(chNum))
                    return preFix.toString();
            }
            preFix.append(curChar);
        }
        return preFix.toString();
    }
}
