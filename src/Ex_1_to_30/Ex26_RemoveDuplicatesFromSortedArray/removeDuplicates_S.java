package Ex_1_to_30.Ex26_RemoveDuplicatesFromSortedArray;

/*
just really simple: use a pointer to point to the place we can add elements
only when we meet an 'new' element.

The main point is: we return an length, and the arr we input with cur length would
be new Arr without duplicate elements.
 */

public class removeDuplicates_S {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        removeDuplicates_S use = new removeDuplicates_S();
        int[] test = new int[]{0, 1, 2};
        int len = use.removeDuplicates(test);
        for (int i = 0; i < len; i++) {
            System.out.println(test[i]);
        }
    }
}
