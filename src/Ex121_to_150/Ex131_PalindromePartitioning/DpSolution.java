package Ex121_to_150.Ex131_PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class DpSolution {

    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        List<List<String>> res = new ArrayList<>();
        dfs(res, s, 0, new ArrayList<>(), dp);
        return res;
    }

    private void dfs(List<List<String>> res, String s, int start, List<String> path, boolean[][] dp) {
        int len = s.length();
        if (start >= len) {
            res.add(new ArrayList<>(path));
        }

        for (int i = start; i < len; i++) {
            if (s.charAt(i) != s.charAt(start)) {
                continue;
            }
            if (i - 1 > start + 1 && !dp[start + 1][i - 1]) {
                continue;
            }
            dp[start][i] = true;
            path.add(s.substring(start, i + 1));
            dfs(res, s, i + 1, path, dp);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        DpSolution s = new DpSolution();
        String input = "aab";
        List<List<String>> partition = s.partition(input);
        for (List<String> strings : partition) {
            for (String string : strings) {
                System.out.print(" " + string);
            }
            System.out.println();
        }
    }
}
