package Ex1648_FistUnrepeatCharInString;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public char firstUniqChar(String s) {
        Queue<Character> theQueue = new LinkedList<>();
        boolean[] removed = new boolean[26];
        for (char c : s.toCharArray()) {
            if (theQueue.remove(c)) // it the queue contains c, then remove c will be true
                removed[c - 'a'] = true;
            else if (!removed[c - 'a'])
                theQueue.add(c);
        }
        if (theQueue.size() != 0)
            return theQueue.peek();
        else
            return ' ';
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        String test = "cbcbdefd";
        System.out.println(use.firstUniqChar(test));
    }
}
