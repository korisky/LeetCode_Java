package Ex1_300.Ex1_to_30.Ex3_LongestSubstringWithoutRepeatingCharacters;

/*

 */

public class ExtremeFastSolution {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        // 由于输入只有 a-z, A-Z, 可以用128存
        int[] digitIdx = new int[128];

        int start = 0;
        int end = 0;
        int result = 0;
        char curDigit;

        // 持续向右拓展end
        while (end < s.length()) {
            // curDigit获取当前字符
            curDigit = s.charAt(end);
            // 这里start是指, 要么保持上一个start, 要么当前字符已经遇到过, 那就直接获取
            start = Math.max(start, digitIdx[curDigit]);

            // 进行比较, 更新result也就是最大长度
            result = Math.max(result, end - start + 1);
            // 更新digitIdx -> 为end+1, 也就是要下一个开始, 因为当前digit的index代表重复
            digitIdx[curDigit] = end + 1;
            end++;
        }

        return result;
    }

    public static void main(String[] args) {
        ExtremeFastSolution use = new ExtremeFastSolution();
        String test = "asdbasbuiabweibiuebfleuaksfkjsdbkcjbkjcbkbkzxckSBKDCBKsbduiqwsakdsakdhasjkdhkjasdhjkasdhjksadhjkadhjkasdjkhasjkdhasjkdhjkasdhasjkdhas";

        long startTime = System.currentTimeMillis();
        System.out.println(use.lengthOfLongestSubstring(test));
        long endTime = System.currentTimeMillis();
        System.out.println("Program Running Time：" + (endTime - startTime) + "ms");
    }
}
