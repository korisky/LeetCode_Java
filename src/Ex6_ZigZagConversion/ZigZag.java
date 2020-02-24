package Ex6_ZigZagConversion;

public class ZigZag {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length())
            return s;

        String[] store = new String[numRows];
        for (int i = 0; i < numRows; i++)
            store[i] = "";

        int step = 1;
        int rowPointer = 0;

        for (int i = 0; i < s.length(); i++){
            store[rowPointer] += s.charAt(i);
            if (rowPointer == 0)
                step = 1;
            if (rowPointer == numRows - 1)
                step = -1;
            rowPointer += step;
        }

        String result = "";
        for (String str: store)
            result += str;

        return result;
    }

    public static void main(String[] args) {
        ZigZag use = new ZigZag();
        System.out.println(use.convert("PAYPALISHIRING", 4));
    }
}
