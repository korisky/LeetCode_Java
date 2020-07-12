package Ex91_to_120.Ex119_PascalsTriangleII;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {

        int[] save = new int[rowIndex + 1];
        save[0] = 1;
        for (int r = 1; r < rowIndex + 1; r++) {
            int lastLeft = 1;
            for (int c = 1; c <= r; c++) {
                int temp = save[c];
                save[c] += lastLeft;
                lastLeft = temp;
            }
        }

        List<Integer> res = new LinkedList<>();
        for (int num : save) {
            res.add(num);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        List<Integer> res = use.getRow(3);
        for (int i : res)
            System.out.print(i + " ");
    }
}
