package Ex153_FindMinimumRotatedSortedArray;

/**
 * 因为是一个sorted的list, 实质上找到升序降序交叉点即可
 * 需要注意, 因为最后赋值lowest都是使用nums[mid], left和right不能随意++或者--, 否则会跳过部分元素
 */
public class SearchSolution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int lowest = Math.min(nums[left], nums[right]);
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < lowest) {
                // e.g. [4,5,1,2,3] situation, set left to mid
                // e.g. [5,1,2,3,4] situation, set left to mid
                lowest = nums[mid];
                right = mid - 1;
            } else if (nums[mid] >= lowest) {
                // e.g. [3,4,5,1,2]
                left = mid + 1;
            }
        }
        return lowest;
    }

    public static void main(String[] args) {
        SearchSolution ss = new SearchSolution();
        int[] test1 = new int[]{3, 4, 5, 1, 2};
        int[] test2 = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] test3 = new int[]{11, 13, 15, 17};
        int[] test4 = new int[]{5, 1, 2, 3, 4};
        int[] test5 = new int[]{3, 4, 5, 6, 1, 2};
//        System.out.println(ss.findMin(test1));
//        System.out.println(ss.findMin(test2));
//        System.out.println(ss.findMin(test3));
//        System.out.println(ss.findMin(test4));
        System.out.println(ss.findMin(test5));
    }
}
