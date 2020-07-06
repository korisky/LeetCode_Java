package Ex31_to_60.Ex38_CountAndSay;

public class countAndSay_S {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        return analyze(countAndSay(n - 1));
    }

    private static String analyze(String res) {
        StringBuilder b = new StringBuilder();
        int count = 1;
        char curr = res.charAt(0);
        for (int i = 1; i < res.length(); i++) {
            char atI = res.charAt(i);
            if (atI != curr) {
                b.append(count).append(curr);
                curr = atI;
                count = 1;
            } else {
                count++;
            }
        }
        b.append(count).append(curr);
        return b.toString();
    }
}
