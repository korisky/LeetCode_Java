package Ex1_300.Ex31_to_60.Ex43_MultiplyStrings;

/*
    Faster Implementation from GitHub + slightly changed, more self-explanations code
 */

public class multiply_faster {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
            return "";

        if (num1.equals("0") || num2.equals("0"))
            return "0";

        StringBuilder num1Rev = new StringBuilder(num1).reverse();


        char[] str1 = num1.toCharArray();
        char[] str2 = num2.toCharArray();
        int[] store = new int[str1.length + str2.length];

        for (int i = str1.length - 1; i >= 0; i--) {
            for (int j = str2.length - 1; j >= 0; j--) {
                store[(str1.length - 1 - i) + (str2.length - 1 - j)] += (str1[i] - '0') * (str2[j] - '0');
            }
        }
        /*
        Above situation can be seen as:
            e.g. a = "12", b = "123"
                digit * digit = a0b0, a0b1, a0b2, a1b0, a1b1, a1b2
                0 + 0 = 0......
                            0, 1, 2
                                1, 2, 3
         */

//        for (int num : store)
//            System.out.println(num);
//        System.out.println();

        int carry = 0;
        for (int i = 0; i < store.length; i++) {
            int curSlotSum = store[i] + carry;
            carry = curSlotSum / 10;
            store[i] = curSlotSum % 10;
        }

//        for (int num : store)
//            System.out.println(num);
//        System.out.println();


        int startIndex = store.length - 1;
        while (startIndex >= 0 && store[startIndex] == 0)
            startIndex--;

        StringBuilder sb = new StringBuilder();
        for (int index = startIndex; index >= 0; index--)
            sb.append(store[index]);
        return sb.toString();
    }

    public static void main(String[] args) {
        multiply_faster use = new multiply_faster();
        String a = "9";
        String b = "12";
        System.out.println(use.multiply(a, b));
    }
}
