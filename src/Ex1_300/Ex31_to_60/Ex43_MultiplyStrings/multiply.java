package Ex1_300.Ex31_to_60.Ex43_MultiplyStrings;

/*
Instead using String.charAt(), we convert String into char[] before,
this would perform much more faster
 */

public class multiply {
    public String multiply(String num1, String num2) {

        if (num1 == null || num2 == null
                || num1.length() == 0 || num2.length() == 0)
            return "";

        if (num1.equals("0") || num2.equals("0"))
            return "0";

        char[] longStr;
        char[] shortStr;
        if (num1.length() > num2.length()) {
            longStr = num1.toCharArray();
            shortStr = num2.toCharArray();
        } else {
            longStr = num2.toCharArray();
            shortStr = num1.toCharArray();
        }

        // every 2 elements multiply would not exceed: nums1 + nums2, e.g. 99 x 99 = 9801
        int[] store = new int[longStr.length + shortStr.length];

        // Every times we use a single digit from SHORT to multiply the whole long digit
        // we multiply the long digit 1 by 1.
        for (int i = shortStr.length - 1, basePush = 0; i >= 0; i--, basePush++) {
            int shortDigit = shortStr[i] - '0';
            if (shortDigit == 0)
                continue;
            for (int j = longStr.length - 1, addPush = 0; j >= 0; j--, addPush++) {
                int curSlotResult = store[basePush + addPush] + shortDigit * (longStr[j] - '0');
                store[basePush + addPush + 1] += curSlotResult / 10;
                store[basePush + addPush] = curSlotResult % 10;
            }
        }
        // The result in store is REVERSE !!!
//        for (int num : store)
//            System.out.println(num);

        int startIndex = store.length - 1;
        while (startIndex >= 0 && store[startIndex] == 0)
            startIndex--;

        StringBuilder sb = new StringBuilder();
        for (int index = startIndex; index >= 0; index--)
            sb.append(store[index]);
        return sb.toString();
    }

    public static void main(String[] args) {
        multiply use = new multiply();
        String a = "0";
        String b = "0";
        System.out.println(use.multiply(a, b));
    }
}
