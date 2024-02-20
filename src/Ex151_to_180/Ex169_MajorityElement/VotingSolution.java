package Ex151_to_180.Ex169_MajorityElement;

/**
 * 算法特点是, 只有在一定存在一个major element, 并且它的频率 > 总长的1/2
 */
public class VotingSolution {

    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
            } else if (nums[i] == major) {
                count++;
            } else if (nums[i] != major) {
                count--;
            }
        }
        return major;
    }

}
