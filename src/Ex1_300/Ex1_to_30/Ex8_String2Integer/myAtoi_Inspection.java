package Ex1_300.Ex1_to_30.Ex8_String2Integer;

public class myAtoi_Inspection {
    public int myAtoi(String str) {

        int ans = 0;
        int i = 0, sign = 1;

        if (str.isEmpty())
            return ans;

        while (i < str.length() && str.charAt(i) == ' ')
            i++;
        if (i < str.length() && str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < str.length() && str.charAt(i) == '+')
            i++;

        while (i < str.length()) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9')
                break;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && str.charAt(i) > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + (str.charAt(i) - '0');
            i++;
        }
        return sign * ans;
    }
}
