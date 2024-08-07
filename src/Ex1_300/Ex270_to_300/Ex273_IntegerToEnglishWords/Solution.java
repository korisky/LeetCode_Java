package Ex1_300.Ex270_to_300.Ex273_IntegerToEnglishWords;

import java.util.Arrays;
import java.util.List;

public class Solution {


    static class NumberWord {
        int value;
        String word;

        public NumberWord(int value, String word) {
            this.value = value;
            this.word = word;
        }
    }

    // List to store words for numbers
    private static final List<NumberWord> NUM_TO_WORD_LIST = Arrays.asList(
            new NumberWord(1000000000, "Billion"), new NumberWord(1000000, "Million"),
            new NumberWord(1000, "Thousand"), new NumberWord(100, "Hundred"),
            new NumberWord(90, "Ninety"), new NumberWord(80, "Eighty"),
            new NumberWord(70, "Seventy"), new NumberWord(60, "Sixty"),
            new NumberWord(50, "Fifty"), new NumberWord(40, "Forty"),
            new NumberWord(30, "Thirty"), new NumberWord(20, "Twenty"),
            new NumberWord(19, "Nineteen"), new NumberWord(18, "Eighteen"),
            new NumberWord(17, "Seventeen"), new NumberWord(16, "Sixteen"),
            new NumberWord(15, "Fifteen"), new NumberWord(14, "Fourteen"),
            new NumberWord(13, "Thirteen"), new NumberWord(12, "Twelve"),
            new NumberWord(11, "Eleven"), new NumberWord(10, "Ten"),
            new NumberWord(9, "Nine"), new NumberWord(8, "Eight"),
            new NumberWord(7, "Seven"), new NumberWord(6, "Six"),
            new NumberWord(5, "Five"), new NumberWord(4, "Four"),
            new NumberWord(3, "Three"), new NumberWord(2, "Two"),
            new NumberWord(1, "One")
    );

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        for (NumberWord nw : NUM_TO_WORD_LIST) {
            if (num >= nw.value) {
                String prefix = (num >= 100) ? numberToWords(num / nw.value) + " " : "";
                String unit = nw.word;
                String suffix = (num % nw.value == 0) ? "" : " " + numberToWords(num % nw.value);
                return prefix + unit + suffix;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(10086));
    }
}
