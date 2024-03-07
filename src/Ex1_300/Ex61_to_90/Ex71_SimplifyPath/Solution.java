package Ex1_300.Ex61_to_90.Ex71_SimplifyPath;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String s : path.split("/")) {
            if (s.equals(".."))
                stack.poll();
            else if (!s.equals("") && !s.equals("."))
                stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        if (stack.size() == 0)
            return "/";
        while (stack.size() != 0)
            sb.append("/").append(stack.pollLast());
        return sb.toString();
    }
}
