package Ex1_300.Ex1_to_30.Ex11_ContainerWithMostWater;

/*
Main idea here is about: we keep narrow two 'bars' as left one and right one
Each step, we narrow the one with shorter height, as we narrow it, the length
between two bars would become smaller, we can only get greater MAXAREA by finding
a taller bar than the current shorter one, in this shallower distance between two bars
 */

public class maxAreaSolution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxAr = 0;
        while (left < right){
            int curAr = (right - left) * Math.min(height[left], height[right]);
            if (curAr > maxAr)
                maxAr = curAr;
            if (height[left] > height[right]){
                right--;
            } else {
                left++;
            }
        }
        return maxAr;
    }

    public static void main(String[] args) {
        maxAreaSolution use = new maxAreaSolution();
        System.out.println(use.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
