package Ex601_900.Ex752_OpenTheLock;

import java.util.*;

public class Solution {


    /**
     * 题目类似机械旋钮的锁, 询问从0000到target一共要几步, 并且其中不可以碰到deadEnds里面的情况
     * 首先想到的就是bottom-up的从target到0000的转换, 类似backtrack的dfs, 但实际这样会走更多无关的情况, 更基础的办法是使用BFS, 然后对其中部分进行剪枝
     */
    public static int openLock_BasicBFS(String[] deadends, String target) {

        Queue<String> q = new LinkedList<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();

        // 题目规定了是4位数
        q.offer("0000");
        visited.add("0000");

        // level也就是次数
        int level = 0;

        // BFS的方式进行层序遍历
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String s = q.poll();
                // 如果找到了, 直接返回level
                if (target.equals(s)) {
                    return level;
                }
                // 剪枝, 如果包含在deadEnds中跳过
                if (deads.contains(s)) {
                    continue;
                }
                // 进行遍历, 将每一位数字的+1和-1的操作都进行添加到queue中
                StringBuilder sb = new StringBuilder(s);
                for (int i = 0; i < 4; i++) {
                    char c = sb.charAt(i);
                    // s1属于+1, 添加一位
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    // s2属于-1, 降低一位
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if (!visited.contains(s1) && !deads.contains(s1)) {
                        q.offer(s1);
                        visited.add(s1);
                    }
                    if (!visited.contains(s2) && !deads.contains(s2)) {
                        q.offer(s2);
                        visited.add(s2);
                    }
                }
            }
            // 该层结束遍历, level+1
            level++;
        }
        return -1;
    }

    /**
     * 这个方法是双向search, 每次单个search完毕之后, 将另一个倒转, 进行反向search
     */
    public static int openLock_2End(String[] deadends, String target) {
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));

        begin.add("0000");
        end.add(target);

        int level = 0;
        Set<String> tmp;
        while (!begin.isEmpty() && !end.isEmpty()) {

            // 每次都从较小的那个开始遍历
            if (begin.size() > end.size()) {
                tmp = begin;
                begin = end;
                end = tmp;
            }

            // 类似前面的方式, 同时将可能存在的都进加入到set内部
            tmp = new HashSet<>();
            for (String s : begin) {
                if (end.contains(s)) return level;
                if (deadSet.contains(s)) continue;

                deadSet.add(s);
                StringBuilder sb = new StringBuilder(s);
                for (int i = 0; i < 4; i++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if (!deadSet.contains(s1)) tmp.add(s1);
                    if (!deadSet.contains(s2)) tmp.add(s2);
                }
            }
            level++;
            begin = tmp;
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(openLock_BasicBFS(new String[]{"8888"}, "0009"));
        System.out.println(openLock_2End(new String[]{"8888"}, "0009"));
//        System.out.println(openLock_BasicBFS(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
//        System.out.println(openLock_2End(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }


}
