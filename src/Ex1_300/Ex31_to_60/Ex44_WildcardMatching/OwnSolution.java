package Ex1_300.Ex31_to_60.Ex44_WildcardMatching;

public class OwnSolution {
    public boolean isMatch(String s, String p) {

        boolean[][] table = new boolean[s.length() + 1][p.length() + 1];
        table[0][0] = true;

        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();

        for (int c = 0; c < pChar.length; c++) { // check whether pattern can pass empty string
            if (pChar[c] == '*')
                table[0][c + 1] = table[0][c];
        }

        for (int r = 0; r < sChar.length; r++) {
            for (int c = 0; c < pChar.length; c++) {
                if (pChar[c] == '*') {
                    table[r + 1][c + 1] = (table[r + 1][c] | table[r][c] | table[r][c + 1]);
                    // used '*' as:           1) never         2) once       3) sequence
                } else if (sChar[r] == pChar[c] | pChar[c] == '?') {
                    table[r + 1][c + 1] = table[r][c];
                }
            }
        }

        return table[sChar.length][pChar.length];
    }
}
