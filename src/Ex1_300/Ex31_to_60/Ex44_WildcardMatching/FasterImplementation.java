package Ex1_300.Ex31_to_60.Ex44_WildcardMatching;

public class FasterImplementation {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int m = s.length();
        int n = p.length();

        int last_match = -1, starj = -1;
        while (i < m){
            if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
                i++;
                j++;
            } else if (j < n && p.charAt(j) == '*'){
                starj = j;
                j++;
                last_match = i;
            } else if (starj != -1){
                j = starj + 1;
                last_match++;
                i = last_match;
            } else {
                return false;
            }
        }
        while (j < n && p.charAt(j) == '*') j++;
        return j == n;
    }

    public static void main(String[] args) {
        FasterImplementation use = new FasterImplementation();
        String p = "aba*c";
        String s = "ababbc";
        System.out.println(use.isMatch(s, p));
    }
}
