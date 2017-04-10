package OJ;

/**
 * Created by arachis on 2017/4/10.
 * 判断一个经过移动的有序，可能重复的数组是否含有指定值
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 二分查找
 */
public class Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
                //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
                //any of the two sides won't change the result but can help remove duplicate from
                //consideration, here we just use end-- but left++ works too
            } else {
                end--;//left++;
            }
        }

        return false;
    }


}
