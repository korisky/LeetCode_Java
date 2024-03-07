package Ex1201_1500.Ex1306_JumpGame3;

public class OwnSolution {
    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length)
            return false;
        boolean[] met = new boolean[arr.length];
        checking(arr, start, met);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && met[i])
                return true;
        }
        return false;
    }

    public void checking(int[] arr, int curIndex, boolean[] met) {
        // once we call this function, means we met this slot
        met[curIndex] = true;
        int left = curIndex - arr[curIndex];
        int right = curIndex + arr[curIndex];

        if (left >= 0 && !met[left])
            checking(arr, left, met);
        if (right < arr.length && !met[right])
            checking(arr, right, met);
    }

    public static void main(String[] args) {
        OwnSolution use = new OwnSolution();
        int[] arr = new int[]{4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        System.out.println(use.canReach(arr, start));
    }
}
