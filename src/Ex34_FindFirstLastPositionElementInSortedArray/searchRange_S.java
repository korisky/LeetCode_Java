package Ex34_FindFirstLastPositionElementInSortedArray;

public class searchRange_S {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                int first = mid, last = mid;
                boolean movefirst = false, movelast = false;
                while (first >= 0 && nums[first] == target) {
                    first--;
                    movefirst = true;
                }
                while (last <= nums.length - 1 && nums[last] == target) {
                    last++;
                    movelast = true;
                }
                if (movefirst)
                    first++;
                if (movelast)
                    last--;
                return new int[]{first, last};

            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        searchRange_S use = new searchRange_S();
        int[] test = new int[]{3, 3, 3,4};
        int[] result = use.searchRange(test, 3);
        for (int i : result)
            System.out.println(i);
    }
}
