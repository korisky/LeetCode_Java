package Ex13_Roman2Integer;

public class RomanToInteger {
    public int getIntVal(char c){
        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            default: return 1000;
        }
    }

    public int romanToInt(String s) {
        s = s.replace("IV", "IIII");
        s = s.replace("IX", "VIIII");
        s = s.replace("XL", "XXXX");
        s = s.replace("XC", "LXXXX");
        s = s.replace("CD", "CCCC");
        s = s.replace("CM", "DCCCC");
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += getIntVal(s.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger use = new RomanToInteger();
        System.out.println(use.romanToInt("MCMXCIV"));
    }
}
