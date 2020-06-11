package Extras;

public class MergeSort {

    public void MergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            MergeSort(arr, start, mid);
            MergeSort(arr, mid + 1, end);
            MergeOne(arr, start, mid, end);
        }
    }

    public void MergeOne(int[] arr, int start, int mid, int end) {
        int[] inOrder = new int[end - start + 1];
        int i = 0;
        int l = start;
        int r = mid + 1;
        while (l <= mid && r <= end) {
            if (arr[l] <= arr[r]) {
                inOrder[i++] = arr[l++];
            } else {
                inOrder[i++] = arr[r++];
            }
        }
        while (l <= mid) {
            inOrder[i++] = arr[l++];
        }
        while (r <= end) {
            inOrder[i++] = arr[r++];
        }

        for (int j = 0; j < i; j++) {
            arr[start + j] = inOrder[j];
        }
    }

    public static void main(String[] args) {
        MergeSort use = new MergeSort();
        int[] test = new int[]{2, 6, 3, 1, 9, 13};
        use.MergeSort(test, 0, test.length - 1);
        for (int i : test)
            System.out.println(i);
    }
}
