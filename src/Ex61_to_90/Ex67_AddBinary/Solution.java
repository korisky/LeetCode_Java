package Ex61_to_90.Ex67_AddBinary;

public class Solution {
    public String addBinary(String a, String b) {
        if (a == null && b == null)
            return "";
        else if (a == null || a.length() == 0)
            return b;
        else if (b == null || b.length() == 0)
            return a;

        StringBuilder result = new StringBuilder();
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        int carry = 0;

        while (p1 >= 0 || p2 >= 0 || carry != 0) {
            int curSum = carry;
            if (p1 >= 0)
                curSum += a.charAt(p1--) - '0';
            if (p2 >= 0)
                curSum += b.charAt(p2--) - '0';
            carry = curSum / 2;
            result.insert(0, curSum % 2);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        String s1 = "";
        String s2 = "101";
        System.out.println(use.addBinary(s1, s2));
    }
}
