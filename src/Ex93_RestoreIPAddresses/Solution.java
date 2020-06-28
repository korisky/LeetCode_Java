package Ex93_RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

/*
    The idea is about: using embedded for loops
 */

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0 || s.length() > 12)
            return new ArrayList<>();

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                for (int c = 1; c <= 3; c++) {
                    int rest = len - a - b - c;
                    if (rest > 0 && rest <= 3) {
                        int A = Integer.parseInt(s.substring(0, a));
                        int B = Integer.parseInt(s.substring(a, a + b));
                        int C = Integer.parseInt(s.substring(a + b, a + b + c));
                        int D = Integer.parseInt(s.substring(a + b + c));
                        if (A <= 255 && B <=255 && C <= 255 && D <= 255){
                            sb.append(A).append(".").append(B).append(".").append(C).append(".").append(D);
                            if (sb.length() == len + 3)
                                res.add(sb.toString());
                            sb = new StringBuilder();
                        }
                    }
                }
            }
        }
        return res;
    }
}
