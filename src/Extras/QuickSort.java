package Extras;

public class QuickSort {
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int minEleIdx = low - 1;

        for (int curIdx = low; curIdx < high; curIdx++) {
            if (arr[curIdx] <= pivot) {
                swap(arr, ++minEleIdx, curIdx);
            }
        }
        swap(arr, ++minEleIdx, high);
        return minEleIdx;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void calling(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] test = new int[]{3, 6, 2, 9, 1};
        QuickSort use = new QuickSort();
        use.calling(test);
        for (int i : test)
            System.out.println(i);
    }
}
