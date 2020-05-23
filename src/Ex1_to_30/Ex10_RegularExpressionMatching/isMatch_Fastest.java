package Ex1_to_30.Ex10_RegularExpressionMatching;

public class isMatch_Fastest {
    public boolean isMatch(String s, String p) {
        // more like a linear search problem, but there are different options(branches),
        // for example. for *, we need to decide how many chars we can match
        // so this transfer to dfs options. and could we memorized it? like remember
        // the match results of certain index. yes we could memorized the failed
        // suffix match, so that we can return false immediately
        int[][] mem = new int[s.length()][p.length()];
        return dfs(s, p, 0, 0, mem);
    }

    private boolean dfs(String s, String p, int si, int pi, int[][] mem) {
        // if si or pi reach to the end
        if (si == s.length() || pi == p.length()) {
            // p finsihed, s not
            if (si != s.length())
                return false;
            // s finished, p not, there is poosible that following pi can be empty, like a, ab*
            if (pi != p.length()) {
                // the only possible way that they could mathc is p has to follow a*b*c*d*
                if (p.charAt(p.length() - 1) != '*')
                    return false;
                pi++;
                while (pi < p.length()) {
                    if (p.charAt(pi) != '*')
                        return false;
                    pi += 2;
                }
                return true;
            }
            // both finished
            return true;
        }

        if (mem[si][pi] < 0)
            return false;

        boolean wild = false;
        // assuming input wildcard will always append to a real char a-z or ./
        // there will be no consecutive *, so we just checck pi+1 for the wildcard
        if (pi < p.length() - 1 && p.charAt(pi + 1) == '*')
            wild = true;

        // if wildcard, then there are multiple options from 0 match to n match
        if (wild) {
            int match = 0;
            while (true) {
                // (pi,pi+1) could match to (si, si+match-1), then we recursively search from pi+2, si+match.
                if (dfs(s, p, si + match, pi + 2, mem))
                    return true;
                match++;
                // s+match-1 is the point we gonna match with pi currently
                if (si + match - 1 >= s.length())
                    break;
                char sc = s.charAt(si + match - 1);
                // sc can't match with pi
                if (sc != p.charAt(pi) && p.charAt(pi) != '.')
                    break;
            }
            mem[si][pi] = -1;
            return false;

        } else {
            // no wildcard, then we just need to take care of current si and pi
            if (p.charAt(pi) == '.' || p.charAt(pi) == s.charAt(si))
                return dfs(s, p, si + 1, pi + 1, mem);
            mem[si][pi] = -1;
            return false;
        }
    }

    public static void main(String[] args) {
        isMatch_Fastest use = new isMatch_Fastest();
        System.out.println(use.isMatch("aa", "a*"));
    }
}
