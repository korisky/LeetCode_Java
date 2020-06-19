package Ex84_LargestRectangleInHistogram;

/*
    The idea is about: if we are in index I, we find the leftest and rightest index
    with the height just >= heights[I]. Then traverse the heights, we can use:
    heights[I] * (rights[I] - lefts[I] - 1)

    we use minFromL to store minIndex from left.
 */

public class FasterSolution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        if (heights.length == 1)
            return heights[0];

        int len = heights.length;
        int[] minFromL = new int[len]; // store: the left smallest element's index that is >= current height
        int[] minFromR = new int[len];
        minFromL[0] = -1;
        minFromR[len - 1] = len;

        for (int i = 1; i < len; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i])
                p = minFromL[p];
            minFromL[i] = p;
        }

        for (int i = len - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < len && heights[p] >= heights[i])
                p = minFromR[p];
            minFromR[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < len; i++)
            maxArea = Math.max(maxArea, heights[i] * (minFromR[i] - minFromL[i] - 1));

        return maxArea;
    }

    public static void main(String[] args) {
        FasterSolution use = new FasterSolution();
        int[] test = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(use.largestRectangleArea(test));
    }
}
