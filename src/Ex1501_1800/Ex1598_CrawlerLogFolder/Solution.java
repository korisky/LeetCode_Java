package Ex1501_1800.Ex1598_CrawlerLogFolder;

public class Solution {

    public static int minOperations(String[] logs) {
        int step = 0;
        for (String log : logs) {
            if ("./".equalsIgnoreCase(log)) {
                continue;
            }
            if ("../".equalsIgnoreCase(log)) {
                if (step > 0) {
                    step--;
                }
                continue;
            }
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
        System.out.println(minOperations(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}));
        System.out.println(minOperations(new String[]{"d1/", "../", "../", "../"}));
        System.out.println(minOperations(new String[]{"./","wz4/","../","mj2/","../","../","ik0/","il7/"}));
    }
}
