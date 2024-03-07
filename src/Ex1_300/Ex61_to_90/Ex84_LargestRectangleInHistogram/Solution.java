package Ex1_300.Ex61_to_90.Ex84_LargestRectangleInHistogram;

import java.util.Stack;

/*
    The idea is about using two stack to store index and height respectively.

    If current index's height is greater than the top one in stack,
    we just add index and it's height.

    If not: we need to keep pop out the height and index,
     and update area with: [popHeight * (curIdx - popIdx)]

    Finally, we still need to take care of the stuff inside the stack
    with: [popHeight * (height.len - popIdx)]
 */

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        if (heights.length == 1)
            return heights[0];

        Stack<Integer> theIdx = new Stack<>();
        Stack<Integer> maxHeight = new Stack<>();
        int maxArea = 0;

        theIdx.push(0);
        maxHeight.push(heights[0]);
        // traverse the heights
        for (int curIdx = 1; curIdx < heights.length; curIdx++) {
            int curHeight = heights[curIdx];
            if (curHeight > maxHeight.peek()) {
                theIdx.push(curIdx);
                maxHeight.push(curHeight);
            } else if (curHeight < maxHeight.peek()) {
                // need to pop out
                while (!maxHeight.isEmpty()) {
                    int oldIdx = theIdx.pop();
                    int oldHeight = maxHeight.pop();
                    maxArea = Math.max(maxArea, oldHeight * (curIdx - oldIdx));
                    if (maxHeight.isEmpty() || maxHeight.peek() <= curHeight) {
                        // once we find out the stack is empty, or stack's top element is
                        // less than current height, we can stop
                        theIdx.push(oldIdx);
                        maxHeight.push(curHeight);
                        break;
                    }
                }
            }
        }
        // handle the heights that still in stack
        int maxLen = heights.length;
        while (!maxHeight.isEmpty()) {
            int oldIdx = theIdx.pop();
            int oldHeight = maxHeight.pop();
            maxArea = Math.max(maxArea, oldHeight * (maxLen - oldIdx));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        int[] test = new int[]{1, 1};
        System.out.println(use.largestRectangleArea(test));
    }
}
