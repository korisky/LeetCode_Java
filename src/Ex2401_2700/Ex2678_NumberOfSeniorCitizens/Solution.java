package Ex2401_2700.Ex2678_NumberOfSeniorCitizens;

public class Solution {

    public static int countSeniors(String[] details) {
        int sum = 0;
        for (String detail : details) {
            int age = Integer.parseInt(detail.substring(11, 13));
            if (age > 60) {
                sum++;
            }
        }
        return sum;
    }

    public static int countSeniorsFaster(String[] details) {
        int sum = 0;
        for (String detail : details) {
            char[] charArray = detail.toCharArray();
            if ((charArray[11] - '0') * 10 + (charArray[12] - '0') > 60) {
                sum++;
            }
        }
        return sum;
    }
}
