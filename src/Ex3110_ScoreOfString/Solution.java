package Ex3110_ScoreOfString;

public class Solution {

    public static int scoreOfString(String s) {
        int score = 0;
        char[] ca = s.toCharArray();
        for (int i = 1; i < ca.length; i++) {
            score += Math.abs(ca[i] - ca[i - 1]);
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println(scoreOfString("hello"));
    }
}
