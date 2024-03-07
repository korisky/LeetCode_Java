package Ex1_300.Ex1_to_30.Ex7_ReverseInteger;

public class Reverse {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        sb.reverse();
        if (sb.charAt(sb.length() - 1) == '-'){
            Long result = - Long.parseLong(sb.substring(0, sb.length() - 1));
            if (result < - Math.pow(2, 31))
                return 0;
            else
                return result.intValue();
        } else {
            Long result = Long.parseLong(sb.toString());
            if (result > Math.pow(2, 31) - 1)
                return 0;
            else
                return result.intValue();
        }
    }

    public static void main(String[] args) {
        Reverse use = new Reverse();
        System.out.println(use.reverse(-123));
    }
}
