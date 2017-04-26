package OJ;

/**
 * Created by arachis on 2017/4/26.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 设计算法，在一个数组，一个从升序的数组循环移动成某种顺序的数组；(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 找到这个数组中的最小值；假设数组不重复
 Find the minimum element.
 You may assume no duplicate exists in the array.
 *
 */
public class Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0, end = nums.length - 1;
        /*
        * The minimum element must satisfy one of two conditions:
         *  1) If rotate, A[min] < A[min - 1];
         *  2) If not, A[0].
         * Therefore, we can use binary search:
         * check the middle element, if it is less than previous one, then it is minimum.
         * If not, there are 2 conditions as well:
         *  If it is greater than both left and right element, then minimum element should be on its right, otherwise on its left.
        * */
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];//if it is less than previous one, then it is minimum.
            }
            if (nums[start] <= nums[mid] && nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[start];
    }

}
