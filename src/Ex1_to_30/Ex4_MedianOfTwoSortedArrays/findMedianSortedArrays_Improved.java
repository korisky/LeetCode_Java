package Ex1_to_30.Ex4_MedianOfTwoSortedArrays;

/*
Little improvement:
    Because we just want to find median, which is only needed to find the median or two near by medians.
    Thus, from original method, we use a new pointer call median_index, once we calculate the index of
    the new combined array is > median_index + 1 (+ 1 means we at least need to have that median_index
    be copied). Then we can STOP CONSTRUCT THE New Array, Half the constructing time.

    What's more, we can also HALF the size of total new array.
 */

public class findMedianSortedArrays_Improved {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length == 0)
            return getMedianFromOneArray(nums2);
        else if (nums2 == null || nums2.length == 0)
            return getMedianFromOneArray(nums1);

        int p1 = 0;
        int p2 = 0;
        int p_new = 0;

        int total_length = nums1.length + nums2.length;
        boolean odd = total_length % 2 == 1;
        int median_index = total_length / 2;

        int[] arr = new int[(nums1.length + nums2.length) / 2 + 1];
        while (p1 < nums1.length && p2 < nums2.length && p_new < median_index + 1) {
            if (nums1[p1] < nums2[p2])
                arr[p_new++] = nums1[p1++];
            else
                arr[p_new++] = nums2[p2++];
        }
        while (p1 < nums1.length && p_new < median_index + 1)
            arr[p_new++] = nums1[p1++];

        while (p2 < nums2.length && p_new < median_index + 1)
            arr[p_new++] = nums2[p2++];

        return odd ? arr[median_index] : (arr[median_index] + arr[median_index - 1]) / 2.0;
    }

    public double getMedianFromOneArray(int[] arr) {
        if (arr.length % 2 != 0)
            return arr[arr.length / 2];
        else
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.0;
    }

    public static void main(String[] args) {
        findMedianSortedArrays_Improved use = new findMedianSortedArrays_Improved();
        int[] t1 = new int[]{1, 2};
        int[] t2 = new int[]{3, 4};
        System.out.println(use.findMedianSortedArrays(t1, t2));
    }
}
