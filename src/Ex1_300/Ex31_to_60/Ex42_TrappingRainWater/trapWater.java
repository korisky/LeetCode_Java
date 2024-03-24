package Ex1_300.Ex31_to_60.Ex42_TrappingRainWater;

/*
Using the method from LeetCode,
    the idea here is about using two way scanning and the overlapping
    area would be the real area that contain water. First we scan from
    the left, we assume that the right hand side would always higher
    then the left hand side. Thus, the volume of all traps would only
    be determined by the left hand side's height. (e.g we got [5,2]
    then we would get volume (5-2=3). Again, we do this from right end,
    (e.g we got [2,5] then we get volume(2-5 -> 2)). Then the minimum
    one is the real volume we get, which can be represented by:
    vol[i] = min(left_max - h[i], right_max - h[i])
 */

public class trapWater {
    public int trap(int[] height) {

        if (height.length == 0)
            return 0;

        int[] leftHeight = new int[height.length];
        int[] rightHeight = new int[height.length];

        // 记住初始化, 对于left初始化左边, right初始化右边, 分别直接就是height挡板在那个位置的高度
        leftHeight[0] = height[0];
        rightHeight[height.length - 1] = height[height.length - 1];

        for (int i = 1; i < height.length; i++)
            leftHeight[i] = Math.max(leftHeight[i - 1], height[i]);

        for (int i = height.length - 2; i >= 0; i--)
            rightHeight[i] = Math.max(rightHeight[i + 1], height[i]);

        int water = 0;
        for (int i = 0; i < height.length; i++) {
            int curRealHeight = height[i];
            water += Math.min(leftHeight[i], rightHeight[i]) - curRealHeight;
        }
        return water;
    }
}
