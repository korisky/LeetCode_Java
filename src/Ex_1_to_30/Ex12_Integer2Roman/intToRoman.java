package Ex_1_to_30.Ex12_Integer2Roman;

public class intToRoman {
    public String intToRoman(int num) {
        String[] t = new String[]{"", "M", "MM", "MMM"};
        String[] h = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] d = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] u = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        StringBuffer sb = new StringBuffer();
        sb.append(t[num / 1000]);
        sb.append(h[(num % 1000) / 100]);
        sb.append(d[(num % 100) / 10]);
        sb.append(u[num % 10]);
        return sb.toString();
    }
}
