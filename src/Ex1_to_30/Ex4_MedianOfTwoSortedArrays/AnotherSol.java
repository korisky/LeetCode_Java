package Ex1_to_30.Ex4_MedianOfTwoSortedArrays;

public class AnotherSol {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4, 5};
        int[] nums2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int totalLen = nums1.length + nums2.length;
        int half = totalLen / 2;

        int m1Mid = nums1[(nums1.length - 1) / 2];
        int m2Mid = nums2[half - ((nums1.length - 1) / 2)];

        while (m1Mid < nums1.length - 2 && m2Mid < nums2.length - 2) {
            if (nums2[m2Mid] > nums1[m1Mid + 1]) {
                // num2中的mid比num1中的mid下一位大, 需要拓展num1的取值
                m1Mid++;
            } else if (nums1[m1Mid] > nums2[m2Mid + 1]) {
                // 反之, 拓展m1的值
                m2Mid++;
            } else {
                m1Mid++;
                m2Mid++;
            }
        }

        if (totalLen % 2 == 0) {
            return (Math.max(nums1[m1Mid], nums2[m2Mid]) + Math.min(nums1[m1Mid + 1], nums2[m2Mid + 1])) / 2.0;
        }
        return Math.max(nums1[m1Mid], nums2[m2Mid]);
    }
}
