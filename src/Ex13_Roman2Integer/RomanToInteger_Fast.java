package Ex13_Roman2Integer;

/*
The main point is:
1. the RULE or FORMAT here is about: VI, if we traverse each char, we can still get 5 + 1 = 6 the right result;
But IV, IX, we can't. Instead, we can figure out whether we met this situation by comparing current num we met
and the one we met previously. Thus, we can add any number and result in correct answer by checking like this,
minus preNum if curNum > preNum.
2. Remember, JAVA has SWTICH, which is much faster in checking stuff than HASHMAP
 */

public class RomanToInteger_Fast {
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
        int result = 0;
        int preNum = getIntVal(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            int curNum = getIntVal(s.charAt(i));
            if (curNum > preNum){
                result -= preNum;
            } else {
                result += preNum;
            }
            preNum = curNum;
        }
        result += preNum;
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger_Fast use = new RomanToInteger_Fast();
        System.out.println(use.romanToInt("MCMXCIV"));
    }
}
