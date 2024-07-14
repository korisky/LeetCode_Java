package Ex601_900.Ex726_NumberAtoms;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Solution {

    /**
     * 要对内部括号进行计算, 最后根据存在的元素进行总的计算
     * K4(ON(SO3)2)2 -> K4N2O14S4
     * 一个有效的方法是 Reverse Scanning -> 通过反向的执行可以更快速的进行乘法,
     * 比正向Scanning时Stack操作少很多
     */
    public static String countOfAtoms(String formula) {

        // Atom使用, 注意Map要用TreeMap这种SortedMap,
        // 方便traverse的时候自动按照字母排序
        StringBuilder sb = new StringBuilder();
        char[] charArr = formula.toCharArray();
        Map<String, Integer> freqMap = new TreeMap<>();

        // 运算使用
        int curCount = 1;
        Stack<Integer> multiStack = new Stack<>();
        multiStack.push(1);

        for (int i = charArr.length - 1; i >= 0; i--) {

            char curChar = charArr[i];

            // 元素处理, 进行插入
            if (Character.isLetter(curChar)) {
                sb.insert(0, curChar);
                // 如果属于单个元素, 进行计算
                if (Character.isUpperCase(curChar)) {
                    // 计算
                    String curAtom = sb.toString();
                    Integer count = freqMap.getOrDefault(curAtom, 0);
                    freqMap.put(curAtom, count + multiStack.peek() * curCount);
                    // clear
                    sb = new StringBuilder();
                    curCount = 1;
                }
                continue;
            }

            // 次数处理
            if (Character.isDigit(curChar)) {
                // 次数最大化 -> 向左匹配
                StringBuilder digitBuilder = new StringBuilder(String.valueOf(curChar));
                while (Character.isDigit(charArr[i - 1])) {
                    digitBuilder.insert(0, charArr[i - 1]);
                    i--;
                }
                curCount = Integer.parseInt(digitBuilder.toString());
                continue;
            }

            // ) 括号处理
            if (')' == curChar) {
                multiStack.push(multiStack.peek() * curCount);
                curCount = 1;
                continue;
            }

            // ( 括号处理
            if ('(' == curChar) {
                multiStack.pop();
            }
        }

        // 遍历FreqMap
        sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
        System.out.println(countOfAtoms("Na2ZnRb5(PuS11(SH)6W)2(H2S)Unu8Pu"));
//        System.out.println(countOfAtoms("Be32"));
    }
}
