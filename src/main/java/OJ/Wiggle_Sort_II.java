package OJ;

/**
 * Created by arachis on 2017/10/5.
 *
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

 Example:
 (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

 Note:
 You may assume all input has valid answer.

 Follow Up:
 Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class Wiggle_Sort_II {

    /**
     * we can arrange the elements in the three categories in a deterministic way.
     (1) Elements that are larger than the median: we can put them in the first few odd slots;
     (2) Elements that are smaller than the median: we can put them in the last few even slots;
     (3) Elements that equal the median: we can put them in the remaining slots.
     to re-map the indices into its destined indices, odd indices first and even indices follow.

     Example:

     Original Indices:    0  1  2  3  4  5  6  7  8  9 10 11
     Mapped Indices:      1  3  5  7  9 11  0  2  4  6  8 10
     (its reverse mapping is)

     Mapped Indices:      0  1  2  3  4  5  6  7  8  9 10 11
     Original Indices:    6  0  7  1  8  2  9  3 10  4 11  5   (wiggled)
     In order to achieve this, we can use a function alike

     int map_index(int idx, int n) {
     return (2 * idx + 1) % (n | 1);
     }
     where (n | 1) calculates the nearest odd that is not less than n.
     */

    public void wiggleSort(int[] nums) {
        int median = median(nums, (nums.length - 1) / 2); //二分位数
        int l = 0; int m = 0; int r = nums.length - 1;
        while(m <= r){
            if(nums[get(nums, m)] > median)
                swap(nums, get(nums, m++), get(nums, l++));
            else if(nums[get(nums, m)] < median)
                swap(nums, get(nums, m), get(nums, r--));
            else m++;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int median(int[] nums, int k){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int pi = partition(nums, left, right);
            if(pi == k) return nums[pi];
            else if(pi > k) right = pi - 1;
            else left = pi + 1;
        }
        return 0;
    }

    private int partition(int[]nums, int left, int right){
        int pivot = nums[right];
        int lessIndex = left - 1;
        for(int i = left; i < right; i++){
            if(nums[i] <= pivot){
                lessIndex++;
                swap(nums, i, lessIndex);
            }
        }
        swap(nums, lessIndex + 1, right);
        return lessIndex + 1;
    }

    private int get(int[] nums, int i){
        if(i <= (nums.length / 2 - 1)) return i * 2 + 1;
        return (i - nums.length / 2) * 2;
    }

}
