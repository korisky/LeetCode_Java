package Ex1_to_30.Ex27_RemoveElement;

public class AnotherSol {


    /**
     * 排序算法会复杂化这个问题, 不需要排序的情况下实际上只需要swap就可以达到目的
     */
    public int removeElement(int[] nums, int val) {

        // Conner case
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // swap不同元素到array前面
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[idx++] = nums[i];
            }
        }

        // idx 正好是swap了多少次
        return idx;
    }

}
