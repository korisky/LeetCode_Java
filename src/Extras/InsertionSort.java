package Extras;

/**
 * From https://www.youtube.com/watch?v=GhP5WbE4GYo InsertionSort
 *
 * @param arr
 * @param <T>
 */
public record InsertionSort<T extends Comparable<T>>(T[] arr) {

    public void sort(int start, int end) {
        // could update using binary search
        for (int i = start; i <= end; i++) {
            int j = i;
            while (j > 0 && arr[j].compareTo(arr[j - 1]) < 0) {
                // swap
                T tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
                j--;
            }
        }
    }
}
