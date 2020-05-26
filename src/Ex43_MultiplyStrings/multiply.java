package Ex43_MultiplyStrings;

public class multiply {
    public String multiply(String num1, String num2) {

        if (num1 == null || num2 == null
                || num1.length() == 0 || num2.length() == 0)
            return "";

        String longer = num1;
        String shorter = num2;
        if (num1.length() < num2.length()) {
            longer = num2;
            shorter = num1;
        }

        // every 2 elements multiply would not exceed: nums1 + nums2, e.g. 99 x 99 = 9801
        int[] store = new int[num1.length() + num2.length()];

        // Every times we use a single digit from SHORT to multiply the whole long digit
        // we multiply the long digit 1 by 1.
        for (int i = shorter.length() - 1, basePush = 0; i >= 0; i--, basePush++) {
            int curShortDigit = shorter.charAt(i) - '0';
            if (curShortDigit == 0)
                continue; // no need to multiply 0
            for (int j = longer.length() - 1, longPush = 0; j >= 0; j--, longPush++) {
                int curMul = curShortDigit * (longer.charAt(j) - '0'); // get current slot's multiply result
                int curSlotSum = store[basePush + longPush] + curMul; // get the whole sum
                store[basePush + longPush + 1] += curSlotSum / 10; // behave like a CARRIER
                store[basePush + longPush] = curSlotSum % 10; // We use = here, cause we only need to add % 10
            }
        }
        // The result in store is REVERSE !!!
        for (int num : store)
            System.out.println(num);

        StringBuilder sb = new StringBuilder();
        int startIndex = store.length - 1;
        while (startIndex >= 0 && store[startIndex] == 0 )
            startIndex--;

        if (startIndex < 0)
            return "0";
        else {
            for (int index = 0; index <= startIndex; index++)
                sb.insert(0, store[index]);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        multiply use = new multiply();
        String a = "0";
        String b = "0";
        System.out.println(use.multiply(a, b));
    }
}
