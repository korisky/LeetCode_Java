package Ex1201_1500.Ex1405_LongestHappyString;

import java.util.*;

public class Solution {

    public static class Comb {

        private int remainNum;
        private char cha;

        public Comb(int remainNum, char cha) {
            this.remainNum = remainNum;
            this.cha = cha;
        }

        public int getRemainNum() {
            return remainNum;
        }

        public char getCha() {
            return cha;
        }

        public void decrement() {
            this.remainNum--;
        }
    }


    /**
     * 1) 只能有abc
     * 2) 不能出现 aaa, bbb, ccc
     * 3) abc的次数需要固定的
     */
    public static String longestDiverseString(int a, int b, int c) {

        List<Comb> combs = Arrays.asList(
                new Comb(a, 'a'),
                new Comb(b, 'b'),
                new Comb(c, 'c')
        );
        StringBuilder sb = new StringBuilder();

        while (true) {

            boolean idling = true;
            combs.sort((x, y) -> Integer.compare(y.getRemainNum(), x.getRemainNum()));

            for (int i = 0; i < combs.size(); i++) {

                Comb comb = combs.get(i);
                if (comb.remainNum == 0) {
                    continue;
                }

                int len = sb.length();
                if (len >= 2 && comb.getCha() == sb.charAt(len - 1) && comb.getCha() == sb.charAt(len - 2)) {
                    continue;
                }

                sb.append(comb.getCha());
                comb.decrement();

                // 每次只加一个char
                idling = false;
                break;
            }

            if (idling) {
                break;
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(longestDiverseString(7, 1, 0));
        System.out.println(longestDiverseString(1, 1, 7));
    }
}
