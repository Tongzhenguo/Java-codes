package OJ;

/**
 * Created by arachis on 2017/5/2.
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
  一个指定的整型数组nums,长度大于1，设计算法output[i]等于除了nums[i]的所有元素的最大公约数，要求时间是0（N）,并且不能使用除法，是否可以只使用O(1)的内存
 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].
 Follow up:
 Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 */
public class Product_of_Array_Except_Self {
    /**
     * Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except 4 is 2*3*5 which consists of two parts: left 2*3 and right 5. The product is left*right. We can get lefts and rights:
     *
     Numbers:     2    3    4     5
     Lefts:            2  2*3 2*3*4
     Rights:  3*4*5  4*5    5
     Let’s fill the empty with 1:

     Numbers:     2    3    4     5
     Lefts:       1    2  2*3 2*3*4
     Rights:  3*4*5  4*5    5     1

     We can calculate lefts and rights in 2 loops. The time complexity is O(n).
     We store lefts in result array. If we allocate a new array for rights. The space complexity is O(n). To make it O(1), we just need to store it in a variable which is right
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        // The product is left*right
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

}
