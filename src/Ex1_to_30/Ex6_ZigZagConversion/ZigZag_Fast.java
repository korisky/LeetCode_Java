package Ex1_to_30.Ex6_ZigZagConversion;

/*
This method is about:
1. enter each row by first column's element: int pos = row;
2. first, find same row's next element (the one with column that only conatins one element)
by running down and go to right (except last row)
3. second, find same row's next next element (the one with column that full of elements)
by running up and go to down (except first row)
4. in 2,3 if we find (pos > s.length - 1), we need to break.
 */

public class ZigZag_Fast {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length())
            return s;
        StringBuffer sb = new StringBuffer();
        for (int row = 0; row < numRows; row++){
            int pos = row;
            if (pos >= s.length())
                break;
            sb.append(s.charAt(pos));
            do{
                if (row != numRows - 1){
                    pos += numRows - row - 1;
                    pos += numRows - row - 1;
                    if (pos >= s.length())
                        break;
                    sb.append(s.charAt(pos));
                }
                if (row != 0){
                    pos += row;
                    pos += row;
                    if (pos >= s.length())
                        break;
                    sb.append(s.charAt(pos));
                }
            } while (pos < s.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ZigZag_Fast use = new ZigZag_Fast();
        System.out.println(use.convert("PAYPALISHIRING", 4));
    }
}

