package Ex_1_to_30.Ex4_MedianOfTwoSortedArrays;

/*
Basically, do the MERGEONE step similar to the MERGESORT,
then return median according to the total number of nums1+nums2 is odd or even
 */

public class findMedianSortedArrays_O {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int p_new = 0;
        int[] arr = new int[nums1.length + nums2.length];
        while (p1 < nums1.length && p2 < nums2.length){
            if (nums1[p1] <= nums2[p2]){
                arr[p_new] = nums1[p1];
                p1++;
            } else {
                arr[p_new] = nums2[p2];
                p2++;
            }
            p_new++;
        }
        while (p1 < nums1.length){
            arr[p_new] = nums1[p1];
            p_new++;
            p1++;
        }
        while (p2 < nums2.length){
            arr[p_new] = nums2[p2];
            p_new++;
            p2++;
        }
        int midIndex = arr.length / 2;
        return arr.length % 2 == 1 ? (arr[midIndex] / 1.0) : (arr[midIndex] + arr[midIndex - 1]) / 2.0;
    }

    public static void main(String[] args) {
        findMedianSortedArrays_O use = new findMedianSortedArrays_O();
        int[] t1 = new int[]{1, 2};
        int[] t2 = new int[]{3, 4};
        System.out.println(use.findMedianSortedArrays(t1, t2));

    }
}
