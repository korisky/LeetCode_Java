package Ex1201_1500.Ex1306_JumpGame3;

public class FasterSolution {
    public boolean canReach(int[] arr, int start) {
        if (arr != null && start >= 0 && start < arr.length) {

            int jump = arr[start]; // if jump == 0, means we can reach a 0
            arr[start] = arr.length; // make this slot 'dead', no longer with any valid jump
            return jump == 0 || canReach(arr, start - jump) || canReach(arr, start + jump);
        }
        return false;
    }
}
