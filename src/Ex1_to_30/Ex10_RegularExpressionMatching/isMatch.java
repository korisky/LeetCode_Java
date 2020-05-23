package Ex1_to_30.Ex10_RegularExpressionMatching;

public class isMatch {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] table = new boolean[sLen + 1][pLen + 1];
        table[0][0] = true; // empty string match empty patten;
        for (int j = 1; j < pLen + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                table[0][j] = table[0][j - 2]; // * can be used as 0 times
            }
        }
        for (int i = 1; i < sLen + 1; i++) {
            for (int j = 1; j < pLen + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                    table[i][j] = table[i - 1][j - 1]; // it would be true if is it true so far
                else if (p.charAt(j - 1) == '*') {
                    table[i][j] = table[i][j - 2]; // 1. the situation that we use * as 0 times
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')
                        // 2. in situations that we use * at least once (containing sub-situations like
                        // a. p: .*    b. p: a*   s: aa)
                        table[i][j] = table[i][j] || table[i - 1][j];// select one situation that really happened
                    // here table[i-1][j]
                }
            }
        }
        return table[sLen][pLen];
    }

    public static void main(String[] args) {
        isMatch use = new isMatch();
        System.out.println(use.isMatch("aa", "a*"));
    }
}
